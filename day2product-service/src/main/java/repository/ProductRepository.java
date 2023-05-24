package repository;

import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

/*
    CREATE TABLE Product (
        id serial primary key,
        name text,
        type text,
        location text,
        warranty date
    );
 */

public class ProductRepository {
    private final List<Product> products = new ArrayList<>();
    private final Connection connection;

    public ProductRepository() {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/javarush", "user", "pass");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void save(Product product) {
        String query = "INSERT INTO Product (name, type, location, warranty) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, product.getName());
            statement.setString(2, product.getType());
            statement.setString(3, product.getLocation());
            statement.setDate(4, new java.sql.Date(product.getWarrantyExpirationDate().getTime()));
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Stream<Product> findAll() {
        String query = "SELECT id, name, type, location, warranty FROM Product";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            return getProductStream(statement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Product findOneByName(String name) {
        String query = "SELECT id, name, type, location, warranty FROM Product WHERE name = ? LIMIT 1";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return getProductFromResultSet(resultSet);
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Stream<Product> findByLocation(String location) {
        String query = "SELECT id, name, type, location, warranty FROM Product WHERE location = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, location);
            return getProductStream(statement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public Stream<Product> findByText(String text) {
        String finalText = '%' + text + '%';
        String query = "SELECT id, name, type, location, warranty FROM Product WHERE name LIKE ? OR type LIKE ? OR location LIKE ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, finalText);
            statement.setString(2, finalText);
            statement.setString(3, finalText);
            return getProductStream(statement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Stream<Product> findWithWarrantyExpired() {
        final Date currentDate = new Date();
        String query = "SELECT id, name, type, location, warranty FROM Product WHERE warranty < ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setDate(1, new java.sql.Date(currentDate.getTime()));
            return getProductStream(statement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Stream<Product> getProductStream(PreparedStatement statement) throws SQLException {
        List<Product> result = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            result.add(getProductFromResultSet(resultSet));
        }
        return result.stream();
    }

    private Product getProductFromResultSet(ResultSet resultSet){
        try {
            Product product = new Product(
                    resultSet.getString("name"),
                    resultSet.getString("type"),
                    resultSet.getString("location"),
                    resultSet.getDate("warranty").toString()
            );
            product.setId(resultSet.getInt("id"));
            return product;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

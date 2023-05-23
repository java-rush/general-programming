package service;

import model.Product;
import repository.ProductQuery;
import repository.ProductRepository;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public class ProductService {

    ProductRepository repository = new ProductRepository();

    public Product addProduct(Product product) {
        return repository.save(product);
    }

    public Stream<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product findByName(String name) {
        return repository.findOne(product -> product.getName().equalsIgnoreCase(name));
    }

    public Stream<Product> findByLocation(String location) {
        return repository.findMany(product -> product.getLocation().equalsIgnoreCase(location));
    }

    public Stream<Product> findByText(String text) {
        String finalText = text.toLowerCase();
        return repository.findMany(
                product -> {
                    String name = product.getName().toLowerCase();
                    String type = product.getType().toLowerCase();
                    String location = product.getLocation().toLowerCase();
                    return name.contains(finalText) || location.contains(finalText) || type.contains(finalText);
                }
        );
    }

    public Stream<Product> findOutOfWarrantyProducts() {
        Date currentDate = new Date();
        return repository.findMany(product -> {
            return product.getWarrantyExpirationDate() != null &&
                    product.getWarrantyExpirationDate().compareTo(currentDate) < 0;
        });
    }
}

package repository;

import model.Product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public class ProductRepository {
    private final List<Product> products = new ArrayList<>();
    public void save(Product product) {
        product.setId(products.size() + 1);
        products.add(product);
    }

    public Stream<Product> findAll() {
        return products.stream();
    }

    public Product findOneByName(String name) {
        return products.stream()
                .filter(product -> product.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public Stream<Product> findByLocation(String location) {
        return products.stream()
                .filter(product -> product.getLocation().equalsIgnoreCase(location));
    }


    public Stream<Product> findByText(String text) {
        final String finalText = text.toLowerCase();
        return products.stream()
                .filter(product -> {
                    final String name = product.getName().toLowerCase();
                    final String type = product.getType().toLowerCase();
                    final String location = product.getLocation().toLowerCase();
                    return name.contains(finalText) ||
                            type.contains(finalText) ||
                            location.contains(finalText);
                });
    }

    public Stream<Product> findWithWarrantyExpired() {
        final Date currentDate = new Date();
        return products.stream()
                .filter(
                        product -> product.getWarrantyExpirationDate() != null &&
                                product.getWarrantyExpirationDate().compareTo(currentDate) < 0
                );
    }
}

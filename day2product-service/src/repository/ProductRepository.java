package repository;

import model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ProductRepository {
    private final List<Product> products = new ArrayList<>();
    public Product save(Product product) {
        product.setId(products.size() + 1);
        products.add(product);
        return product;
    }

    public Stream<Product> findAll() {
        return products.stream();
    }

    public Product findOne(ProductQuery query) {
        for (Product product: products) {
            if (query.match(product)) {
                return product;
            }
        }
        return null;
    }

    public Stream<Product> findMany(ProductQuery query) {
        return products.stream()
                .filter(query::match);
    }
}

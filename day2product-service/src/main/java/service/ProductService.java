package service;

import model.Product;
import repository.ProductRepository;

import java.util.stream.Stream;

public class ProductService {

    ProductRepository repository = new ProductRepository();

    public void addProduct(Product product) {
        repository.save(product);
    }

    public Stream<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product findByName(String name) {
        return repository.findOneByName(name);
    }

    public Stream<Product> findByLocation(String location) {
        return repository.findByLocation(location);
    }

    public Stream<Product> findByText(String text) {
        return repository.findByText(text);
    }

    public Stream<Product> findOutOfWarrantyProducts() {
        return repository.findWithWarrantyExpired();
    }
}

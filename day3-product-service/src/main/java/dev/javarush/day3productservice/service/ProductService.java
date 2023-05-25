package dev.javarush.day3productservice.service;

import dev.javarush.day3productservice.model.Product;
import dev.javarush.day3productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.stream.Stream;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public void addProduct(Product product) {
        repository.save(product);
    }

    public Stream<Product> getAllProducts() {
        return repository.findAll().stream();
    }

    public Product findByName(String name) {
        return repository.findByName(name).orElse(null);
    }

    public Stream<Product> findByLocation(String location) {
        return repository.findByLocation(location).stream();
    }

    public Stream<Product> findByText(String text) {
        return repository.findByText("%" + text + "%").stream();
    }

    public Stream<Product> findOutOfWarrantyProducts() {
        return repository.findByWarrantyExpirationDateLessThan(new Date()).stream();
    }
}

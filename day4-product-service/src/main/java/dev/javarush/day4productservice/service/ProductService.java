package dev.javarush.day4productservice.service;

import dev.javarush.day4productservice.model.Product;
import dev.javarush.day4productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public Product addProduct(Product product) {
        return repository.save(product);
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product findByName(String name) {
        return repository.findByName(name).orElse(null);
    }

    public List<Product> findByLocation(String location) {
        return repository.findByLocation(location);
    }

    public List<Product> findByText(String text) {
        return repository.findByText("%" + text + "%");
    }

    public List<Product> findOutOfWarrantyProducts() {
        return repository.findByWarrantyExpirationDateLessThan(new Date());
    }
}

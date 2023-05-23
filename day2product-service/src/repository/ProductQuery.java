package repository;

import model.Product;

public interface ProductQuery {
    boolean match(Product product);
}

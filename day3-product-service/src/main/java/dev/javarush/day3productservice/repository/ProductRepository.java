package dev.javarush.day3productservice.repository;

import dev.javarush.day3productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Optional<Product> findByName(String name);

    List<Product> findByLocation(String location);

    @Query(
            value = "SELECT id, name, type, location, warranty FROM Product WHERE name LIKE ?1 OR type LIKE ?1 OR location LIKE ?1",
            nativeQuery = true
    )
    List<Product> findByText(String text);

    List<Product> findByWarrantyExpirationDateLessThan(Date date);
}

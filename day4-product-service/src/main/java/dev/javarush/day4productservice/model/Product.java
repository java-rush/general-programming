package dev.javarush.day4productservice.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonKey;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String type;
    private String location;

    @Column(name = "warranty")
    @JsonProperty("warranty")
    private Date warrantyExpirationDate;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public Product(String name, String type, String location, String warrantyExpirationDate /* "2023-05-23" */) {
        this.name = name;
        this.type = type;
        this.location = location;
        try {
            this.warrantyExpirationDate = dateFormat.parse(warrantyExpirationDate);
        } catch (ParseException e) {
            this.warrantyExpirationDate = null;
        }
    }

    public Product(String name, String type, String location, Date warrantyExpirationDate /* "2023-05-23" */) {
        this.name = name;
        this.type = type;
        this.location = location;
        this.warrantyExpirationDate = warrantyExpirationDate;
    }

    public Product() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setWarrantyExpirationDate(Date warrantyExpirationDate) {
        this.warrantyExpirationDate = warrantyExpirationDate;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getLocation() {
        return location;
    }

    public Date getWarrantyExpirationDate() {
        return warrantyExpirationDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", location='" + location + '\'' +
                ", warrantyExpirationDate=" + warrantyExpirationDate +
                '}';
    }
}

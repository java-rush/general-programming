package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Product {
    private int id;
    private String name;
    private String type;
    private String location;
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

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", location='" + location + '\'' +
                ", warrantyExpirationDate=" + warrantyExpirationDate +
                '}';
    }
}

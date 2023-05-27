package dev.javarush.day4productservice.controller;

import dev.javarush.day4productservice.model.Product;
import dev.javarush.day4productservice.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ProductRestController {

    private final ProductService service;

    public ProductRestController(ProductService service) {
        this.service = service;
    }

    // GET /products --> queryParameter = {}
    // GET /products?location=Brown Table --> queryParameter = {'location': 'Brown Table'}
    // GET /products?location=First Drawer&type=power --> queryParameter = {'location': 'First Drawer', 'type': 'power'}
    @GetMapping("products")
    public List<Product> getAll(@RequestParam Map<String, String> queryParameter) {
        String location = queryParameter.get("location");
        if (location != null) {
            return service.findByLocation(location);
        }
        String text = queryParameter.get("text");
        if (text != null) {
            return service.findByText(text);
        }
        return service.getAllProducts();
    }

    // GET /products/warranty/expired
    @GetMapping("products/warranty/expired")
    public List<Product> getOutOfWarrantyProducts() {
        return service.findOutOfWarrantyProducts();
    }

    // GET /products/Macbook Pro --> name = "Macbook Pro"
    // GET /products/Power Bank --> name = "Power Bank"
    @GetMapping("products/{productName}")
    public Product getByName(@PathVariable("productName") String name) {
        return service.findByName(name);
    }

    /*
        POST /products
        Content-type: application/json

        {
            "name": "Extension Board",
            "type": "power",
            "location": "Brown Table",
            "warranty": "2023-01-20"
        }
     */
    @PostMapping("products")
    public Product addNew(@RequestBody Product product) {
        return service.addProduct(product);
    }
}

import model.Product;
import service.ProductService;

import java.util.List;
import java.util.stream.Stream;

public class ProductServiceApplication {
    public static void main(String[] args) {

        ProductService productService = new ProductService();

        // 1. Add Product
        productService.addProduct(new Product("Dell Laptop", "laptop", "Brown Table", "2020-12-10"));
        productService.addProduct(new Product("Samsung M33", "smartphone", "Brown Table", "2024-04-10"));
        productService.addProduct(new Product("USB-C to HDMI Adapter", "cable", "First Drawer", "2020-12-10"));
        productService.addProduct(new Product("HDMI Cable", "cable", "Brown Table", "2020-12-10"));
        productService.addProduct(new Product("Macbook Pro", "laptop", "Bedroom", "2025-12-10"));
        productService.addProduct(new Product("Sony Headphone", "hearing", "Second Drawer", "2020-12-10"));
        productService.addProduct(new Product("Earbuds", "hearing", "Forth Drawer", "2023-2-10"));
        productService.addProduct(new Product("Jiofi", "internet", "Brown Table", "2020-12-10"));
        productService.addProduct(new Product("Brown Wallet", "personal", "Forth Drawer", "2020-12-10"));
        productService.addProduct(new Product("Black Wallet", "personal", "Brown Table", "2020-12-10"));
        productService.addProduct(new Product("Drawer Keys", "personal", "Brown Table", "2020-12-10"));
        productService.addProduct(new Product("Power Bank", "power", "First Drawer", "2024-12-10"));
        productService.addProduct(new Product("Trail Blazer Book", "book", "Second Drawer", "2020-12-10"));
        productService.addProduct(new Product("Double Sided Tap", "utility", "Brown Table", "2020-12-10"));
        productService.addProduct(new Product("Macbook Charger", "power", "Bedroom", "2020-12-10"));
        productService.addProduct(new Product("Dell Charger", "power", "Brown Table", "2020-12-10"));
        productService.addProduct(new Product("Samsung Charger", "power", "Brown Table", "2020-12-10"));
        productService.addProduct(new Product("iPhone", "smartphone", "First Drawer", "2023-12-10"));
        productService.addProduct(new Product("iPhone Charger", "power", "Second Drawer", "2020-12-10"));

        // 2. Get all products
//        Stream<Product> allProducts = productService.getAllProducts();
//        allProducts.forEach(System.out::println);

        // 3. Get Product using name (exact match ignoring casing)
//        Product product = productService.findByName("Samsung Charger");
//        System.out.println(product);

        // 4. Get Product by location
//        Stream<Product> products = productService.findByLocation("Brown Table");
//        products.forEach(System.out::println);

        // 5. Get Product by name, type, location (substring match)
//        Stream<Product> products = productService.findByText("laptop");
//        products.forEach(System.out::println);

        // 6. Get out of warranty products
        Stream<Product> products = productService.findOutOfWarrantyProducts();
        products.forEach(System.out::println);
    }
}

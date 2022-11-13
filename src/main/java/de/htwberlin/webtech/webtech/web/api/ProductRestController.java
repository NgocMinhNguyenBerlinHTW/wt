package de.htwberlin.webtech.webtech.web.api;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductRestController {
    private List<Product> products = new ArrayList<>();

    public ProductRestController() {
        products.add(new Product(1, "Brot", "Brot ist lecker", 1.99));
        products.add(new Product(2, "Milch", "Milch ist lecker", 0.99));
        products.add(new Product(3, "Käse", "Käse ist lecker", 2.99));
    }
    @GetMapping(path = "/api/v1/products")
    /**
    public List<Product> fetchProducts() {
        return products;
    }
    */
    public ResponseEntity<List<Product>> fetchProducts() {
        return ResponseEntity.ok(products);
    }
}

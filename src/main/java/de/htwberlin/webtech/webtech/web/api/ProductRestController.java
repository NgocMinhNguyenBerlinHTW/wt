package de.htwberlin.webtech.webtech.web.api;


import de.htwberlin.webtech.webtech.persistence.ProductEntity;
import de.htwberlin.webtech.webtech.persistence.ProductRepository;
import de.htwberlin.webtech.webtech.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductRestController {

    //inject the repository
    private final ProductService productService;
    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "/api/v1/products")
    /**
    public List<Product> fetchProducts() {
        return products;
    }
    */

    /**
     * example here we implement a method that returns a list of products
     * in the controller.
     * but best practice is to implement this in a service class
     * here we need to transform the List<ProductEntity> to List<Product>
     *     public ResponseEntity<List<Product>> fetchProducts() {
     *         var products = productRepository.findAll().stream().map(ProductEntity ->new Product(
     *                 ProductEntity.getId(),
     *                 ProductEntity.getName(),
     *                 ProductEntity.getDescription(),
     *                 ProductEntity.getPrice())).collect(Collectors.toList());
     *         System.out.println(products);
     *         return ResponseEntity.ok(products);
     *     }
     * */
     // we build more a service class to execute the logic
    public ResponseEntity<List<Product>> fetchProducts() {
        var products = productService.findAllProducts();
        return ResponseEntity.ok(products);


    }
    @PostMapping(path = "/api/v1/products")
    public ResponseEntity <Void> createProduct(@RequestBody  ProductCreateRequest request) throws URISyntaxException {
        var product = productService.create(request);
        URI location = new URI("/api/v1/products/" + product.getId());
        return ResponseEntity.created(location).build();
    }

}

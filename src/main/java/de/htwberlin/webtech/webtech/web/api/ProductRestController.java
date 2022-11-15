package de.htwberlin.webtech.webtech.web.api;


import de.htwberlin.webtech.webtech.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

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
    @GetMapping(path = "/api/v1/products/{id}")
    public ResponseEntity<Product> fetchProduct(@PathVariable long id) {
        var product = productService.findProductById(id);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(product);
    }
    @PutMapping(path = "/api/v1/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable long id, @RequestBody ProductCreateOrRequest request) {
        var product = productService.updateProduct(id, request);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }
    @PostMapping(path = "/api/v1/products")
    public ResponseEntity <Void> createProduct(@RequestBody ProductCreateOrRequest request) throws URISyntaxException {
        var product = productService.create(request);
        URI location = new URI("/api/v1/products/" + product.getId());
        return ResponseEntity.created(location).build();
    }
    @DeleteMapping(path = "/api/v1/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }



}

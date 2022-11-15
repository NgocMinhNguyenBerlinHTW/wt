package de.htwberlin.webtech.webtech.service;

import de.htwberlin.webtech.webtech.persistence.ProductEntity;
import de.htwberlin.webtech.webtech.persistence.ProductRepository;
import de.htwberlin.webtech.webtech.web.api.Product;
import de.htwberlin.webtech.webtech.web.api.ProductCreateOrRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service

public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll().stream().map(
                productEntity -> new Product(
                        productEntity.getId(),
                        productEntity.getName(),
                        productEntity.getDescription(),
                        productEntity.getPrice()
                )
        ).collect(Collectors.toList());
    }

    public Product create(ProductCreateOrRequest request) {
        var productEntity = new ProductEntity(
                request.getName(),
                request.getDescription(),
                request.getPrice());
        productRepository.save(productEntity);
        return new Product(
                productEntity.getId(),
                productEntity.getName(),
                productEntity.getDescription(),
                productEntity.getPrice());
    }

    // we need to implement a method to find a product by id
    public Product findProductById(long id) {
        var productEntity = productRepository.findById(id);
        if (productEntity.isEmpty()) {
            return null;
        }
        return new Product(
                productEntity.get().getId(),
                productEntity.get().getName(),
                productEntity.get().getDescription(),
                productEntity.get().getPrice());

    }

    // create a method to update a product
    public Product updateProduct(long id, ProductCreateOrRequest request) {
        var productEntity = productRepository.findById(id);
        if (productEntity.isEmpty()) {
            return null;
        }
        productEntity.get().setName(request.getName());
        productEntity.get().setDescription(request.getDescription());
        productEntity.get().setPrice(request.getPrice());
        productRepository.save(productEntity.get());
        return new Product(
                productEntity.get().getId(),
                productEntity.get().getName(),
                productEntity.get().getDescription(),
                productEntity.get().getPrice());

    }
    // create a method to delete a product
    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }
}




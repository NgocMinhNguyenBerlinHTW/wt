package de.htwberlin.webtech.webtech.service;

import de.htwberlin.webtech.webtech.persistence.ProductEntity;
import de.htwberlin.webtech.webtech.persistence.ProductRepository;
import de.htwberlin.webtech.webtech.web.api.Product;
import de.htwberlin.webtech.webtech.web.api.ProductCreateRequest;
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

    public Product create (ProductCreateRequest request) {
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
}




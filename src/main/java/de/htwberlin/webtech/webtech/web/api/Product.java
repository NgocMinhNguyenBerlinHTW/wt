package de.htwberlin.webtech.webtech.web.api;

import de.htwberlin.webtech.webtech.persistence.ProductEntity;

public class Product {
    private long id;
    private String name;
    private String description;
    private double price;

    public Product() {
    }
    public Product(long id, String name, String description, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Product(ProductEntity productEntity) {
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }
}

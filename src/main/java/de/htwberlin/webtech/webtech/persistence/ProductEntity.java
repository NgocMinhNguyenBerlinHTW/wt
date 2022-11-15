package de.htwberlin.webtech.webtech.persistence;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "products")
public class ProductEntity {
    // annotation for primary key
    @Id
    // annotation for auto increment
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "price",nullable = false)
    private double price;







    public ProductEntity( String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public ProductEntity() {

    }


    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

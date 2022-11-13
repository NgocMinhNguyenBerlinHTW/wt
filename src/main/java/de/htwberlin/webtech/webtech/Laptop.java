package de.htwberlin.webtech.webtech;

import org.springframework.stereotype.Component;

@Component
public class Laptop {
    private int id;
    private String brand;
    private String model;

    public Laptop() {
        super();
        System.out.println("a latop created");

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                '}';
    }

    void info(){
        System.out.println(this.toString());
    }
}

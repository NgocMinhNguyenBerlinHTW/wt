package de.htwberlin.webtech.webtech.web.api;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private long id;
    private LocalDate date;
    private String status;
    private List<OrderProduct> orderProducts = new ArrayList<>();

    public Order() {
    }

    public Order( LocalDate date, String status, List<OrderProduct> orderProducts) {
        this.date = date;
        this.status = status;
        this.orderProducts = orderProducts;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }


}

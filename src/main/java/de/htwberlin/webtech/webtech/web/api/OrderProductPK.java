package de.htwberlin.webtech.webtech.web.api;


public class OrderProductPK implements java.io.Serializable {
    private Order order;
    private Product product;

    public OrderProductPK() {
    }

    public OrderProductPK(Order order, Product product) {
        this.order = order;
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

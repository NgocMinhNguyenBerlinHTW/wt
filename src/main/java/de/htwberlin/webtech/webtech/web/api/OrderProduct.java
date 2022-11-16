package de.htwberlin.webtech.webtech.web.api;

public class OrderProduct {
    private OrderProductPK orderProductPK;
    private int quantity;

    public OrderProduct() {
    }

    public OrderProduct(OrderProductPK orderProductPK, int quantity) {
        this.orderProductPK = orderProductPK;
        this.quantity = quantity;
    }

    public OrderProductPK getOrderProductPK() {
        return orderProductPK;
    }

    public void setOrderProductPK(OrderProductPK orderProductPK) {
        this.orderProductPK = orderProductPK;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }



}

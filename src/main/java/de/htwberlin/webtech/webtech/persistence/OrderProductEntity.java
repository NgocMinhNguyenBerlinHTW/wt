package de.htwberlin.webtech.webtech.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import de.htwberlin.webtech.webtech.web.api.OrderProductPK;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Id;

public class OrderProductEntity {
    @EmbeddedId
    @JsonIgnore
    private OrderProductPK orderProductPK;

    @Column(nullable = false)
    private Integer quantity;

    public OrderProductEntity() {
    }

    public OrderProductEntity(OrderProductPK orderProductPK, Integer quantity) {
        this.orderProductPK = orderProductPK;
        this.quantity = quantity;
    }

    public OrderProductPK getOrderProductPK() {
        return orderProductPK;
    }

    public void setOrderProductPK(OrderProductPK orderProductPK) {
        this.orderProductPK = orderProductPK;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}

package de.htwberlin.webtech.webtech.persistence;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

public class OrderProductPKEntity implements Serializable {

    @JsonBackReference
    @ManyToOne(optional = false,fetch = javax.persistence.FetchType.LAZY)
    @JoinColumn(name = "order_id",referencedColumnName = "id")
    private OrderEntity order;

    @ManyToOne(optional = false,fetch = javax.persistence.FetchType.LAZY)
    @JoinColumn(name = "product_id",referencedColumnName = "id")
    private ProductEntity product;

    public OrderProductPKEntity() {
    }

    public OrderProductPKEntity(OrderEntity order, ProductEntity product) {
        this.order = order;
        this.product = product;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }


}

package com.example.Spring_Security.domain;


import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import java.io.Serializable;


@Entity
public class OrderItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotNull
    @NotEmpty
    private String refProduct;
    @NotNull
    private Integer quantity;
    private Double price;

    @ManyToOne
    private Order order;

    public OrderItem() {
    }

    public OrderItem(String refProduct, Integer quantity, Double price, Order order) {
        this.refProduct = refProduct;
        this.quantity = quantity;
        this.price = price;
        this.order = order;
    }

    public String getRefProduct() {
        return refProduct;
    }

    public void setRefProduct(String refProduct) {
        this.refProduct = refProduct;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}

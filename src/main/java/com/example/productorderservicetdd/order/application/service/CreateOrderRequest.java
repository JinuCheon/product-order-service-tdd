package com.example.productorderservicetdd.order.application.service;

import org.springframework.util.Assert;

public record CreateOrderRequest(Long productId, int quantity) {
    public CreateOrderRequest(Long productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
        Assert.notNull(productId, "productId must not be null");
        Assert.isTrue(quantity > 0, "quantity must be greater than 0");
    }
}

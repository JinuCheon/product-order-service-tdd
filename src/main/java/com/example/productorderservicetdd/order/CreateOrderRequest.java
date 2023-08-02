package com.example.productorderservicetdd.order;

import org.springframework.util.Assert;

record CreateOrderRequest(Long productId, int quantity) {
    CreateOrderRequest(Long productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
        Assert.notNull(productId, "productId must not be null");
        Assert.isTrue(quantity > 0, "quantity must be greater than 0");
    }
}

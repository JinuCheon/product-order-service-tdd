package com.example.productorderservicetdd.payment;

import org.springframework.util.Assert;

record PaymentRequest(Long orderId, String cardNumber) {
    PaymentRequest(Long orderId, String cardNumber) {
        Assert.notNull(orderId, "orderId must not be null");
        Assert.notNull(cardNumber, "cardNumber must not be null");
        this.orderId = orderId;
        this.cardNumber = cardNumber;
    }
}

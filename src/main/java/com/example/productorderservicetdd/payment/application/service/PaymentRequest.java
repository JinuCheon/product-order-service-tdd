package com.example.productorderservicetdd.payment.application.service;

import org.springframework.util.Assert;

public record PaymentRequest(Long orderId, String cardNumber) {
    public PaymentRequest(Long orderId, String cardNumber) {
        Assert.notNull(orderId, "orderId must not be null");
        Assert.notNull(cardNumber, "cardNumber must not be null");
        this.orderId = orderId;
        this.cardNumber = cardNumber;
    }
}

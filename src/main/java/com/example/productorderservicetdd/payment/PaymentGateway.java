package com.example.productorderservicetdd.payment;

/**
 * PG 연동을 위한 인터페이스
 */
public interface PaymentGateway {
    void execute(int totalPrice, String cardNumber);
}

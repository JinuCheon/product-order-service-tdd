package com.example.productorderservicetdd.payment.application.port;

import com.example.productorderservicetdd.order.domain.Order;
import com.example.productorderservicetdd.payment.domain.Payment;

public interface PaymentPort {
    Order getOrder(Long orderId);

    void pay(int price, String cardNumber);

    void save(Payment payment);
}

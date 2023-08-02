package com.example.productorderservicetdd.payment;

import com.example.productorderservicetdd.order.Order;

interface PaymentPort {
    Order getOrder(Long orderId);

    void pay(int price, String cardNumber);

    void save(Payment payment);
}

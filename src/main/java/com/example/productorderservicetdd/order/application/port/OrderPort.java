package com.example.productorderservicetdd.order.application.port;

import com.example.productorderservicetdd.order.domain.Order;
import com.example.productorderservicetdd.product.domain.Product;

public interface OrderPort {
    Product getProductById(Long productId);

    void save(Order order);
}

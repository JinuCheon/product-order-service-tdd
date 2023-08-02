package com.example.productorderservicetdd.order;

import com.example.productorderservicetdd.product.Product;

public interface OrderPort {
    Product getProductById(Long productId);

    void save(Order order);
}

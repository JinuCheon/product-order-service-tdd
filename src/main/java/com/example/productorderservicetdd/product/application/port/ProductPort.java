package com.example.productorderservicetdd.product.application.port;

import com.example.productorderservicetdd.product.domain.Product;

public interface ProductPort {
    void save(Product product);

    Product getProduct(Long productId);
}

package com.example.productorderservicetdd.product;

interface ProductPort {
    void save(Product product);

    Product getProduct(Long productId);
}

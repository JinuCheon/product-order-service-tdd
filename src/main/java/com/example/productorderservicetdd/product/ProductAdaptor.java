package com.example.productorderservicetdd.product;

import org.springframework.stereotype.Component;

@Component
class ProductAdaptor implements ProductPort {
    private final ProductRepository productRepository;

    ProductAdaptor(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product getProduct(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("상품을 찾을 수 없습니다."));
    }
}

package com.example.productorderservicetdd.product;

class ProductAdaptor implements ProductPort {
    private final ProductRepository productRepository;

    ProductAdaptor(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }
}

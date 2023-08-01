package com.example.productorderservicetdd.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

class ProductServiceTest {

    private ProductPort productPort;
    private ProductService productService;

    @BeforeEach
    void setUp() {
        productPort = Mockito.mock(ProductPort.class);
        productService = new ProductService(productPort);
    }

    @Test
    void 상품수정() {
        Long productId = 1L;
        when(productPort.getProduct(productId)).thenReturn(new Product("상품명", 1000, DiscountPolicy.NONE));

        UpdateProductRequest updateProductRequest = new UpdateProductRequest("상품업데이트", 1000, DiscountPolicy.NONE);

        productService.updateProduct(productId, updateProductRequest);
    }

}

package com.example.productorderservicetdd.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class ProductServiceTest {

    @Autowired ProductService productService;

    @Test
    void 상품조회() {
        // 상품 등록
        productService.addProduct(ProductSteps.상품등록요청_생성());
        final Long productId = 1L;

        // 상품 조회
        final GetProductResponse response = productService.getProduct(productId);

        // 응답 검증. 검증을 먼저 만듦!
        assertThat(response).isNotNull();
    }

}

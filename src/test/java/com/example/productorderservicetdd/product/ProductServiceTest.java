package com.example.productorderservicetdd.product;

import com.example.productorderservicetdd.product.application.service.GetProductResponse;
import com.example.productorderservicetdd.product.application.service.ProductService;
import com.example.productorderservicetdd.product.application.service.UpdateProductRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    ProductService productService;


    @Test
    void 상품수정() {
        productService.addProduct(ProductSteps.상품등록요청_생성());
        final Long productId = 1L;
        final UpdateProductRequest request = ProductSteps.상품수정요청_생성();

        productService.updateProduct(productId, request);

        ResponseEntity<GetProductResponse> response = productService.getProduct(productId);
        GetProductResponse body = response.getBody();
        assertThat(body.name()).isEqualTo("상품업데이트");
        assertThat(body.price()).isEqualTo(1000);
    }

}

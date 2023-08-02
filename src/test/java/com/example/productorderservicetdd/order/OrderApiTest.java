package com.example.productorderservicetdd.order;

import com.example.productorderservicetdd.ApiTest;
import com.example.productorderservicetdd.order.application.service.CreateOrderRequest;
import com.example.productorderservicetdd.product.ProductSteps;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class OrderApiTest extends ApiTest {

    @Test
    void 상품주문() {

        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());
        final CreateOrderRequest request = OrderSteps.상품주문요청_생성();

        var response = OrderSteps.상품주문요청(request);

        Assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

}

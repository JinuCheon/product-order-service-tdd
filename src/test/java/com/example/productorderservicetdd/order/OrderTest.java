package com.example.productorderservicetdd.order;

import com.example.productorderservicetdd.order.domain.Order;
import com.example.productorderservicetdd.product.domain.DiscountPolicy;
import com.example.productorderservicetdd.product.domain.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OrderTest {

    @Test
    void getTotalPrice() {
        final Order order = new Order(new Product("상품명", 2000, DiscountPolicy.FIX_1000_AMOUNT), 1);

        final int totalPrice = order.getTotalPrice();

        Assertions.assertThat(totalPrice).isEqualTo(1000);
    }
}
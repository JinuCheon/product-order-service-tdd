package com.example.productorderservicetdd.product.application.service;

import com.example.productorderservicetdd.product.domain.DiscountPolicy;
import org.springframework.util.Assert;

public record UpdateProductRequest(String name, int price, DiscountPolicy discountPolicy) {
    public UpdateProductRequest {
        Assert.hasText(name, "상품 이름은 필수입니다.");
        Assert.isTrue(price > 0,"상품 가격은 0원보다 커야합니다.");
        Assert.notNull(discountPolicy, "할인 정책은 필수입니다.");
    }
}

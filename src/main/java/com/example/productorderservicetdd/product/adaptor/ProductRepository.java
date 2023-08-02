package com.example.productorderservicetdd.product.adaptor;

import com.example.productorderservicetdd.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public
interface ProductRepository extends JpaRepository<Product, Long> {
}

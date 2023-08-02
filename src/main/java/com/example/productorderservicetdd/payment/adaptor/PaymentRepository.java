package com.example.productorderservicetdd.payment.adaptor;

import com.example.productorderservicetdd.payment.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}

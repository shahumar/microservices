package com.sumer.labs.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sumer.labs.orderservice.domain.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}

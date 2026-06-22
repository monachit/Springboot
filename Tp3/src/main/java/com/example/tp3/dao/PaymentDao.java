package com.example.tp3.dao;

import com.example.tp3.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentDao extends JpaRepository<Payment, Long> {
    List<Payment> findByCommandReference(String reference);
}

package com.example.tp3.dao;

import com.example.tp3.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends JpaRepository<Product, Long> {
    Product findByCode(String code);
}

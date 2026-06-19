package com.example.demo.dao;

import com.example.demo.entity.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface CommandeDao extends JpaRepository<Commande, Long> {
    Commande findByRef(String ref);

    @Query("SELECT c FROM Commande c WHERE c.total < :total")
    List<Commande> findByTotalLessThan(BigDecimal total);

}

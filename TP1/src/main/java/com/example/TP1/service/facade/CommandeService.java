package com.example.demo.service.facade;

import com.example.demo.entity.Commande;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

public interface CommandeService {

    Commande findByRef(String ref);

    int save(Commande commande);

    List<Commande> findAll();

    List<Commande> findAll(Sort sort);

    int pay(String commandRef, BigDecimal amount);

    @Transactional
    int deleteByReference(String commandRef);
}

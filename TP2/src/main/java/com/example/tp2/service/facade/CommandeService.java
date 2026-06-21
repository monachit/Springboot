package com.example.tp2.service.facade;

import com.example.tp2.entity.Commande;

import java.util.List;

public interface CommandeService {
    int save(Commande commande);

    int delete(String commandeRef);

    List<Commande> findByEtatCommandeCode(String etatCommandeCode);
}

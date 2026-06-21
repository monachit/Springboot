package com.example.tp2.service.facade;

import com.example.tp2.entity.Paiement;

import java.util.List;

public interface PaiementService {
    int pay(String commandeRef, Paiement paiement);

    List<Paiement> findByCommandeRef(String commandeRef);
}

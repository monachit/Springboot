package com.example.tp2.service.impl;

import com.example.tp2.dao.CommandeDao;
import com.example.tp2.dao.EtatCommandeDao;
import com.example.tp2.dao.PaiementDao;
import com.example.tp2.entity.Commande;
import com.example.tp2.entity.Paiement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PaiementService implements com.example.tp2.service.facade.PaiementService {
    @Autowired
    private PaiementDao paiementDao;
    @Autowired
    private CommandeDao commandeDao;
    @Autowired
    private  EtatCommandeDao etatCommandeDao;

    @Override
    public int pay(String commandeRef, Paiement paiement)
    {
        Commande commande = commandeDao.findByReference(commandeRef);
        if (commande == null) {
            return -1;
        }
        BigDecimal newTotalPaid = commande.getTotalPaid().add(paiement.getAmount());
        if (newTotalPaid.compareTo(commande.getTotal()) > 0) {
            return -2;
        }
        paiement.setCommande(commande);
        paiement.setPaiementDate(java.time.LocalDateTime.now());
        paiementDao.save(paiement);

        commande.setTotalPaid(newTotalPaid);
        if (newTotalPaid.compareTo(BigDecimal.ZERO) == 0) {
            commande.setEtatCommande(etatCommandeDao.findByCode("NEW"));
        } else if (newTotalPaid.compareTo(commande.getTotal()) < 0) {
            commande.setEtatCommande(etatCommandeDao.findByCode("PENDING"));
        } else {
            commande.setEtatCommande(etatCommandeDao.findByCode("OK"));
        }

        commandeDao.save(commande);


        return 1;
    }
    @Override
    public List<Paiement> findByCommandeRef(String commandeRef) {
        return paiementDao.findByCommandeReference(commandeRef);
    }

}

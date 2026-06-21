package com.example.tp2.service.impl;

import com.example.tp2.dao.CommandeDao;
import com.example.tp2.dao.EtatCommandeDao;
import com.example.tp2.entity.Commande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CommandeServiceImpl implements com.example.tp2.service.facade.CommandeService {
    @Autowired
    private CommandeDao commandeDao;
    @Autowired
    private EtatCommandeDao etatCommandeDao;

    @Override
    public int save(Commande commande){
        if(commandeDao.findByReference(commande.getReference())!=null){
            return -1;
        }
        commande.setTotalPaid(BigDecimal.ZERO);
        commande.setEtatCommande(etatCommandeDao.findByCode("NEW"));
        commandeDao.save(commande);
        return 1;
    }
    @Override
    public int delete(String commandeRef)
    {
        Commande commande = commandeDao.findByReference(commandeRef);
        if(commande==null){
            return -1;
        }
        else if (commande.getTotalPaid().compareTo(BigDecimal.ZERO ) != 0) {
            return -2;
        }
        commandeDao.delete(commande);
        return 1;
    }
    @Override
    public List<Commande> findByEtatCommandeCode(String etatCommandeCode) {
        return commandeDao.findByEtatCommandeCode(etatCommandeCode);
    }



}

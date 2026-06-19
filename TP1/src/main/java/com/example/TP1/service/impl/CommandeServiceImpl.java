package com.example.demo.service.impl;

import com.example.demo.dao.CommandeDao;
import com.example.demo.entity.Commande;
import com.example.demo.service.facade.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CommandeServiceImpl implements CommandeService {
    @Autowired
    private CommandeDao dao;

    @Override
    public Commande findByRef(String ref) {
        return dao.findByRef(ref);
    }
    @Override
    public int save(Commande commande)
    {
        if (findByRef(commande.getRef()) != null)
            return -1;
        else
        {
            dao.save(commande);
            return 1;
        }
    }

    @Override
    public List<Commande> findAll() {
        return dao.findAll();
    }

    @Override
    public List<Commande> findAll(Sort sort) {
        return dao.findAll(sort);
    }
    @Override
    public int pay(String commandRef, BigDecimal amount)
    {
        Commande commande = findByRef(commandRef);
        if (commande == null)
            return -1;
        else
        {

            if (amount.add(commande.getTotalPaid()).compareTo(commande.getTotal()) <= 0)
            {
                commande.setTotalPaid(amount.add(commande.getTotalPaid()));
                dao.save(commande);
                return 1;
            }
            else
                return -2;
        }
    }
    @Transactional
    @Override
    public int deleteByReference(String commandRef)
    {
        Commande commande = findByRef(commandRef);
        if (commande == null)
            return -1;
        else if (commande.getTotalPaid().compareTo(BigDecimal.ZERO) != 0)
            return -2;
        else
        {
            dao.delete(commande);
            return 1;
        }

    }
}

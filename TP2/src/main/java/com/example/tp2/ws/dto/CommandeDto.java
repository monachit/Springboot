package com.example.tp2.ws.dto;

import com.example.tp2.entity.EtatCommande;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

public class CommandeDto {

    private String reference;
    private BigDecimal total;
    private BigDecimal totalPaid;


    @ManyToOne
    private EtatCommande etatCommande;

    @OneToMany(mappedBy = "commande", cascade = CascadeType.REMOVE)
    private List<PaiementDto> paiements;


    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(BigDecimal totalPaid) {
        this.totalPaid = totalPaid;
    }


    public void setEtatCommande(EtatCommande etatCommande) {
        this.etatCommande = etatCommande;
    }

    public EtatCommande getEtatCommande() {
        return etatCommande;
    }
}



package com.example.tp2.ws.dto;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PaiementDto {

    private Long id;
    private String code;
    private LocalDateTime paiementDate;
    private BigDecimal amount;



    @ManyToOne
    private CommandeDto commandeDto;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getPaiementDate() {
        return paiementDate;
    }

    public void setPaiementDate(LocalDateTime paiementDate) {
        this.paiementDate = paiementDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public CommandeDto getCommande() {
        return commandeDto;
    }
    public void setCommande(CommandeDto commandeDto) {
        this.commandeDto = commandeDto;
    }
}

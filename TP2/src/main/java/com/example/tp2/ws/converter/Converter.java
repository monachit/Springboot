package com.example.tp2.ws.converter;

import com.example.tp2.entity.Commande;
import com.example.tp2.entity.Paiement;
import com.example.tp2.ws.dto.CommandeDto;
import com.example.tp2.ws.dto.PaiementDto;
import org.springframework.stereotype.Component;
import org.springframework.beans.BeanUtils;

@Component
public class Converter {

    public Commande toEntity(CommandeDto dto) {
        Commande entity = new Commande();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    public CommandeDto toDto(Commande entity) {
        CommandeDto dto = new CommandeDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public PaiementDto toDto(Paiement entity) {
        PaiementDto dto  = new PaiementDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public Paiement toEntity(PaiementDto dto) {
        Paiement entity = new Paiement();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }



}
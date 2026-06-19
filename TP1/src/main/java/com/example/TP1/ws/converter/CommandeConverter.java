package com.example.demo.ws.converter;


import com.example.demo.entity.Commande;
import com.example.demo.ws.dto.CommandeDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CommandeConverter {

    public Commande toEntity(CommandeDto dto) {
        if (dto == null) {
            return null;
        }
        Commande entity = new Commande();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    public CommandeDto toDto(Commande entity) {
        if (entity == null) {
            return null;
        }
        CommandeDto dto = new CommandeDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

}

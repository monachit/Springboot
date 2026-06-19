package com.example.demo.ws.facade;

import com.example.demo.entity.Commande;
import com.example.demo.service.facade.CommandeService;
import com.example.demo.ws.converter.CommandeConverter;
import com.example.demo.ws.dto.CommandeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/commandes/")
public class CommandeWs {

    @Autowired
    private CommandeService commandeService;
    @Autowired
    private CommandeConverter converter;


    @GetMapping("/ref/{ref}")
    public CommandeDto findByRef(@PathVariable String ref) {
        Commande entity = commandeService.findByRef(ref);
        return converter.toDto(entity);
    }

    @PostMapping
    public int save(@RequestBody CommandeDto dto) {
        Commande entity = converter.toEntity(dto);
        return commandeService.save(entity);
    }

    @GetMapping
    public List<Commande> findAll(Sort sort) {
        return commandeService.findAll(sort);
    }

    @PostMapping("/ref/{ref}/amount/{amount}")
    public int pay(@PathVariable String ref, @PathVariable BigDecimal amount) {
        return commandeService.pay(ref, amount);
    }

    @Transactional
    @DeleteMapping("/ref/{ref}")
    public int deleteByReference(@PathVariable String commandRef) {
        return commandeService.deleteByReference(commandRef);
    }
}

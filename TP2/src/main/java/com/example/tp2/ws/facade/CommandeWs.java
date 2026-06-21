package com.example.tp2.ws.facade;

import com.example.tp2.entity.Commande;
import com.example.tp2.service.impl.CommandeServiceImpl;
import com.example.tp2.ws.converter.Converter;
import com.example.tp2.ws.dto.CommandeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commandes")
public class CommandeWs {
    @Autowired
    private CommandeServiceImpl commandeService;
    @Autowired
    private Converter converter;

    @PostMapping
    public int save(@RequestBody CommandeDto dto) {
        Commande commande = converter.toEntity(dto);
        return commandeService.save(commande);
    }

    @Transactional
    @DeleteMapping("reference/{reference}")
    public int delete(@PathVariable String reference) {
        return commandeService.delete(reference);
    }

    @GetMapping("/etat/{code}")
    public List<CommandeDto> findByEtatCommandeCode(@PathVariable String code) {
        List<Commande> commandes = commandeService.findByEtatCommandeCode(code);
        return commandes.stream().map(converter::toDto).toList();
    }




}

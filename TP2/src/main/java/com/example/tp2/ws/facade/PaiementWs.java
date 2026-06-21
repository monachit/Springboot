package com.example.tp2.ws.facade;

import com.example.tp2.entity.Paiement;
import com.example.tp2.service.impl.PaiementService;
import com.example.tp2.ws.converter.Converter;
import com.example.tp2.ws.dto.PaiementDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paiements")
public class PaiementWs {
    @Autowired
    private PaiementService paiementService;
    @Autowired
    private Converter converter;

    @PostMapping("/commande/{reference}")
    public int pay(@PathVariable String reference, @RequestBody PaiementDto dto) {
        Paiement paiement = converter.toEntity(dto);
        return paiementService.pay(reference, paiement);
    }

    @GetMapping("/commande/{reference}")
    public List<PaiementDto> findByCommandeRef(@PathVariable String reference) {
        return paiementService.findByCommandeRef(reference).stream().map(converter::toDto).toList();
    }

}

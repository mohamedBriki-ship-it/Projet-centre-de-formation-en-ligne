package com.example.centreformation.controller;

import com.example.centreformation.dto.PaiementDTO;
import com.example.centreformation.service.PaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paiements")
@CrossOrigin(origins = "*")
public class PaiementController {

    @Autowired
    private PaiementService paiementService;

    @PostMapping
    public ResponseEntity<PaiementDTO> createPaiement(@RequestBody PaiementDTO dto) {
        PaiementDTO created = paiementService.createPaiement(dto);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<List<PaiementDTO>> getAllPaiements() {
        List<PaiementDTO> list = paiementService.getAllPaiements();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaiementDTO> getPaiementById(@PathVariable Long id) {
        PaiementDTO dto = paiementService.getPaiementById(id);
        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaiementDTO> updatePaiement(@PathVariable Long id, @RequestBody PaiementDTO dto) {
        PaiementDTO updated = paiementService.updatePaiement(id, dto);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaiement(@PathVariable Long id) {
        boolean deleted = paiementService.deletePaiement(id);
        if (deleted) return ResponseEntity.noContent().build();
        else return ResponseEntity.notFound().build();
    }
}

package com.example.centreformation.controller;

import com.example.centreformation.entity.Paiement;
import com.example.centreformation.service.PaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paiements")
public class PaiementController {

    @Autowired
    private PaiementService paiementService;

    // 🔹 Ajouter un paiement
    @PostMapping
    public ResponseEntity<Paiement> createPaiement(@RequestBody Paiement paiement) {
        Paiement newPaiement = paiementService.createPaiement(paiement);
        return ResponseEntity.ok(newPaiement);
    }

    // 🔹 Obtenir tous les paiements
    @GetMapping
    public ResponseEntity<List<Paiement>> getAllPaiements() {
        List<Paiement> paiements = paiementService.getAllPaiements();
        return ResponseEntity.ok(paiements);
    }

    // 🔹 Obtenir un paiement par ID
    @GetMapping("/{id}")
    public ResponseEntity<Paiement> getPaiementById(@PathVariable Long id) {
        Paiement paiement = paiementService.getPaiementById(id);
        if (paiement != null) {
            return ResponseEntity.ok(paiement);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 🔹 Mettre à jour un paiement
    @PutMapping("/{id}")
    public ResponseEntity<Paiement> updatePaiement(@PathVariable Long id, @RequestBody Paiement paiementDetails) {
        Paiement updated = paiementService.updatePaiement(id, paiementDetails);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 🔹 Supprimer un paiement
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaiement(@PathVariable Long id) {
        boolean deleted = paiementService.deletePaiement(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

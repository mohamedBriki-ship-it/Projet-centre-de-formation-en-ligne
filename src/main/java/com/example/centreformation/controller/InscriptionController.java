package com.example.centreformation.controller;

import com.example.centreformation.dto.InscriptionDTO;
import com.example.centreformation.service.InscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inscriptions")
@CrossOrigin(origins = "*")
public class InscriptionController {

    @Autowired
    private InscriptionService inscriptionService;

    @GetMapping
    public List<InscriptionDTO> getAllInscriptions() {
        return inscriptionService.getAllInscriptions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InscriptionDTO> getInscriptionById(@PathVariable Long id) {
        InscriptionDTO dto = inscriptionService.getInscriptionById(id);
        return (dto != null) ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<InscriptionDTO> createInscription(@RequestBody InscriptionDTO dto) {
        InscriptionDTO created = inscriptionService.createInscription(dto);
        if (created == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InscriptionDTO> updateInscription(@PathVariable Long id, @RequestBody InscriptionDTO dto) {
        InscriptionDTO updated = inscriptionService.updateInscription(id, dto);
        return (updated != null) ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInscription(@PathVariable Long id) {
        boolean deleted = inscriptionService.deleteInscription(id);
        return (deleted) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}

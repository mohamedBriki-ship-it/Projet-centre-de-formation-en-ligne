package com.example.centreformation.controller;

import com.example.centreformation.entity.Formation;
import com.example.centreformation.repository.FormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/formations")
public class FormationController {

    @Autowired
    private FormationRepository formationRepository;

    // 1. Liste toutes les formations
    @GetMapping
    public List<Formation> getAllFormations() {
        return formationRepository.findAll();
    }

    // 2. Trouver une formation par id
    @GetMapping("/{id}")
    public ResponseEntity<Formation> getFormationById(@PathVariable Long id) {
        Optional<Formation> formation = formationRepository.findById(id);
        if (formation.isPresent()) {
            return ResponseEntity.ok(formation.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 3. Ajouter une nouvelle formation
    @PostMapping
    public Formation createFormation(@RequestBody Formation formation) {
        return formationRepository.save(formation);
    }

    // 4. Modifier une formation existante
    @PutMapping("/{id}")
    public ResponseEntity<Formation> updateFormation(@PathVariable Long id, @RequestBody Formation formationDetails) {
        Optional<Formation> formationOptional = formationRepository.findById(id);
        if (formationOptional.isPresent()) {
            Formation formation = formationOptional.get();
            formation.setTitre(formationDetails.getTitre());
            formation.setDescription(formationDetails.getDescription());
            formation.setDureeHeures(formationDetails.getDureeHeures());
            formation.setLogicielCible(formationDetails.getLogicielCible());
            formation.setDateCreation(formationDetails.getDateCreation());
            Formation updatedFormation = formationRepository.save(formation);
            return ResponseEntity.ok(updatedFormation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 5. Supprimer une formation
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFormation(@PathVariable Long id) {
        Optional<Formation> formationOptional = formationRepository.findById(id);
        if (formationOptional.isPresent()) {
            formationRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

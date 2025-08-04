package com.example.centreformation.controller;

import com.example.centreformation.dto.FormationDTO;
import com.example.centreformation.service.FormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/formations")
public class FormationController {

    private final FormationService formationService;

    @Autowired
    public FormationController(FormationService formationService) {
        this.formationService = formationService;
    }

    @GetMapping
    public List<FormationDTO> getAllFormations() {
        return formationService.getAllFormations();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormationDTO> getFormationById(@PathVariable Long id) {
        return formationService.getFormationById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public FormationDTO createFormation(@RequestBody FormationDTO formationDTO) {
        return formationService.createFormation(formationDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FormationDTO> updateFormation(@PathVariable Long id, @RequestBody FormationDTO formationDTO) {
        FormationDTO updated = formationService.updateFormation(id, formationDTO);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFormation(@PathVariable Long id) {
        return formationService.deleteFormation(id) ?
                ResponseEntity.noContent().build() :
                ResponseEntity.notFound().build();
    }
}

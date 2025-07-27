package com.example.centreformation.service;

import com.example.centreformation.entity.Formation;
import com.example.centreformation.repository.FormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormationService {

    private final FormationRepository formationRepository;

    @Autowired
    public FormationService(FormationRepository formationRepository) {
        this.formationRepository = formationRepository;
    }

    // Ajouter une formation
    public Formation createFormation(Formation formation) {
        return formationRepository.save(formation);
    }

    // Récupérer toutes les formations
    public List<Formation> getAllFormations() {
        return formationRepository.findAll();
    }

    // Récupérer une formation par ID
    public Optional<Formation> getFormationById(Long id) {
        return formationRepository.findById(id);
    }

    // Mettre à jour une formation
    public Formation updateFormation(Long id, Formation updatedFormation) {
        return formationRepository.findById(id).map(formation -> {
            formation.setTitre(updatedFormation.getTitre());
            formation.setDescription(updatedFormation.getDescription());
            formation.setDureeHeures(updatedFormation.getDureeHeures());
            formation.setLogicielCible(updatedFormation.getLogicielCible());
            formation.setDateCreation(updatedFormation.getDateCreation());
            return formationRepository.save(formation);
        }).orElse(null);
    }

    // Supprimer une formation
    public boolean deleteFormation(Long id) {
        if (formationRepository.existsById(id)) {
            formationRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

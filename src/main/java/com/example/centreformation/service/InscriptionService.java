package com.example.centreformation.service;

import com.example.centreformation.entity.Inscription;
import com.example.centreformation.repository.InscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InscriptionService {

    @Autowired
    private InscriptionRepository inscriptionRepository;

    // ✅ récupérer toutes les inscriptions
    public List<Inscription> getAllInscriptions() {
        return inscriptionRepository.findAll();
    }

    // ✅ récupérer une inscription par ID
    public Inscription getInscriptionById(Long id) {
        return inscriptionRepository.findById(id).orElse(null);
    }

    // ✅ créer une nouvelle inscription
    public Inscription createInscription(Inscription inscription) {
        return inscriptionRepository.save(inscription);
    }

    // ✅ modifier une inscription existante
    public Inscription updateInscription(Long id, Inscription inscription) {
        Optional<Inscription> optional = inscriptionRepository.findById(id);
        if (optional.isPresent()) {
            Inscription existing = optional.get();
            existing.setUser(inscription.getUser());
            existing.setFormation(inscription.getFormation());
            existing.setDateInscription(inscription.getDateInscription());
            existing.setStatutPaiement(inscription.getStatutPaiement());
            return inscriptionRepository.save(existing);
        }
        return null;
    }

    // ✅ supprimer une inscription par ID
    public boolean deleteInscription(Long id) {
        if (inscriptionRepository.existsById(id)) {
            inscriptionRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

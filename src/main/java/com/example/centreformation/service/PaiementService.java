package com.example.centreformation.service;

import com.example.centreformation.entity.Paiement;
import com.example.centreformation.repository.PaiementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaiementService {

    @Autowired
    private PaiementRepository paiementRepository;

    // 🔹 Ajouter un paiement
    public Paiement createPaiement(Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    // 🔹 Obtenir tous les paiements
    public List<Paiement> getAllPaiements() {
        return paiementRepository.findAll();
    }

    // 🔹 Obtenir un paiement par ID
    public Paiement getPaiementById(Long id) {
        return paiementRepository.findById(id).orElse(null);
    }

    // 🔹 Mettre à jour un paiement
    public Paiement updatePaiement(Long id, Paiement paiementDetails) {
        Paiement paiement = paiementRepository.findById(id).orElse(null);
        if (paiement == null) {
            return null;
        }

        paiement.setMontant(paiementDetails.getMontant());
        paiement.setDatePaiement(paiementDetails.getDatePaiement());
        paiement.setMethodePaiement(paiementDetails.getMethodePaiement());
        paiement.setStatut(paiementDetails.getStatut());
        paiement.setInscription(paiementDetails.getInscription());

        return paiementRepository.save(paiement);
    }

    // 🔹 Supprimer un paiement
    public boolean deletePaiement(Long id) {
        if (paiementRepository.existsById(id)) {
            paiementRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

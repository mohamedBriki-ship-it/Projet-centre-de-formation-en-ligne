package com.example.centreformation.mapper;

import com.example.centreformation.dto.PaiementDTO;
import com.example.centreformation.entity.Inscription;
import com.example.centreformation.entity.Paiement;
import com.example.centreformation.repository.InscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaiementMapper {

    @Autowired
    private InscriptionRepository inscriptionRepository;

    public PaiementDTO toDTO(Paiement paiement) {
        if (paiement == null) return null;
        return new PaiementDTO(
                paiement.getId(),
                paiement.getInscription() != null ? paiement.getInscription().getId() : null,
                paiement.getMontant(),
                paiement.getDatePaiement(),
                paiement.getMethodePaiement(),
                paiement.getStatut()
        );
    }

    public Paiement toEntity(PaiementDTO dto) {
        if (dto == null) return null;
        Paiement paiement = new Paiement();
        paiement.setId(dto.getId());
        paiement.setMontant(dto.getMontant());
        paiement.setDatePaiement(dto.getDatePaiement());
        paiement.setMethodePaiement(dto.getMethodePaiement());
        paiement.setStatut(dto.getStatut());

        if (dto.getInscriptionId() != null) {
            Inscription inscription = inscriptionRepository.findById(dto.getInscriptionId()).orElse(null);
            paiement.setInscription(inscription);
        } else {
            paiement.setInscription(null);
        }
        return paiement;
    }
}

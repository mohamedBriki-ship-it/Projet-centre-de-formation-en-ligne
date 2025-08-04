package com.example.centreformation.service;

import com.example.centreformation.dto.PaiementDTO;
import com.example.centreformation.entity.Paiement;
import com.example.centreformation.mapper.PaiementMapper;
import com.example.centreformation.repository.PaiementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaiementService {

    @Autowired
    private PaiementRepository paiementRepository;

    @Autowired
    private PaiementMapper paiementMapper;

    public PaiementDTO createPaiement(PaiementDTO dto) {
        Paiement entity = paiementMapper.toEntity(dto);
        Paiement saved = paiementRepository.save(entity);
        return paiementMapper.toDTO(saved);
    }

    public List<PaiementDTO> getAllPaiements() {
        return paiementRepository.findAll()
                .stream()
                .map(paiementMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PaiementDTO getPaiementById(Long id) {
        return paiementRepository.findById(id)
                .map(paiementMapper::toDTO)
                .orElse(null);
    }

    public PaiementDTO updatePaiement(Long id, PaiementDTO dto) {
        return paiementRepository.findById(id).map(existing -> {
            existing.setMontant(dto.getMontant());
            existing.setDatePaiement(dto.getDatePaiement());
            existing.setMethodePaiement(dto.getMethodePaiement());
            existing.setStatut(dto.getStatut());
            if (dto.getInscriptionId() != null) {
                inscriptionRepository.findById(dto.getInscriptionId())
                        .ifPresent(existing::setInscription);
            }
            Paiement updated = paiementRepository.save(existing);
            return paiementMapper.toDTO(updated);
        }).orElse(null);
    }

    public boolean deletePaiement(Long id) {
        if (paiementRepository.existsById(id)) {
            paiementRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // لتحسين الشغل، لازم تضيف هذا أيضا
    @Autowired
    private com.example.centreformation.repository.InscriptionRepository inscriptionRepository;
}

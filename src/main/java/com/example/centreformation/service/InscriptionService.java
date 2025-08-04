package com.example.centreformation.service;

import com.example.centreformation.dto.InscriptionDTO;
import com.example.centreformation.entity.Formation;
import com.example.centreformation.entity.Inscription;
import com.example.centreformation.entity.User;
import com.example.centreformation.mapper.InscriptionMapper;
import com.example.centreformation.repository.FormationRepository;
import com.example.centreformation.repository.InscriptionRepository;
import com.example.centreformation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InscriptionService {

    @Autowired
    private InscriptionRepository inscriptionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FormationRepository formationRepository;

    @Autowired
    private InscriptionMapper mapper;

    public List<InscriptionDTO> getAllInscriptions() {
        return inscriptionRepository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public InscriptionDTO getInscriptionById(Long id) {
        return inscriptionRepository.findById(id)
                .map(mapper::toDTO)
                .orElse(null);
    }

    public InscriptionDTO createInscription(InscriptionDTO dto) {
        User user = userRepository.findById(dto.getUserId()).orElse(null);
        Formation formation = formationRepository.findById(dto.getFormationId()).orElse(null);
        if (user == null || formation == null) return null; // ou gérer erreur

        Inscription inscription = mapper.toEntity(dto, user, formation);
        Inscription saved = inscriptionRepository.save(inscription);
        return mapper.toDTO(saved);
    }

    public InscriptionDTO updateInscription(Long id, InscriptionDTO dto) {
        return inscriptionRepository.findById(id).map(existing -> {
            User user = userRepository.findById(dto.getUserId()).orElse(null);
            Formation formation = formationRepository.findById(dto.getFormationId()).orElse(null);
            if (user == null || formation == null) return null;

            existing.setUser(user);
            existing.setFormation(formation);
            existing.setDateInscription(dto.getDateInscription());
            existing.setStatutPaiement(dto.getStatutPaiement());

            Inscription updated = inscriptionRepository.save(existing);
            return mapper.toDTO(updated);
        }).orElse(null);
    }

    public boolean deleteInscription(Long id) {
        if (inscriptionRepository.existsById(id)) {
            inscriptionRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

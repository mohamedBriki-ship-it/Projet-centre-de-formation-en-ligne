package com.example.centreformation.service;

import com.example.centreformation.dto.FormationDTO;
import com.example.centreformation.entity.Formation;
import com.example.centreformation.mapper.FormationMapper;
import com.example.centreformation.repository.FormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FormationService {

    private final FormationRepository formationRepository;

    @Autowired
    public FormationService(FormationRepository formationRepository) {
        this.formationRepository = formationRepository;
    }

    public FormationDTO createFormation(FormationDTO formationDTO) {
        Formation formation = FormationMapper.toEntity(formationDTO);
        return FormationMapper.toDTO(formationRepository.save(formation));
    }

    public List<FormationDTO> getAllFormations() {
        return formationRepository.findAll()
                .stream()
                .map(FormationMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<FormationDTO> getFormationById(Long id) {
        return formationRepository.findById(id)
                .map(FormationMapper::toDTO);
    }

    public FormationDTO updateFormation(Long id, FormationDTO formationDTO) {
        return formationRepository.findById(id).map(existing -> {
            existing.setTitre(formationDTO.getTitre());
            existing.setDescription(formationDTO.getDescription());
            existing.setDureeHeures(formationDTO.getDureeHeures());
            existing.setLogicielCible(formationDTO.getLogicielCible());
            existing.setDateCreation(formationDTO.getDateCreation());
            return FormationMapper.toDTO(formationRepository.save(existing));
        }).orElse(null);
    }

    public boolean deleteFormation(Long id) {
        if (formationRepository.existsById(id)) {
            formationRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

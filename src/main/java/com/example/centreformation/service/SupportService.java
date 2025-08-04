package com.example.centreformation.service;

import com.example.centreformation.dto.SupportDTO;
import com.example.centreformation.entity.Support;
import com.example.centreformation.mapper.SupportMapper;
import com.example.centreformation.repository.SupportRepository;
import com.example.centreformation.repository.FormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupportService {

    @Autowired
    private SupportRepository supportRepository;

    @Autowired
    private SupportMapper supportMapper;

    @Autowired
    private FormationRepository formationRepository;

    public SupportDTO createSupport(SupportDTO dto) {
        Support support = supportMapper.toEntity(dto);
        Support saved = supportRepository.save(support);
        return supportMapper.toDTO(saved);
    }

    public List<SupportDTO> getAllSupports() {
        return supportRepository.findAll()
                .stream()
                .map(supportMapper::toDTO)
                .collect(Collectors.toList());
    }

    public SupportDTO getSupportById(Long id) {
        return supportRepository.findById(id)
                .map(supportMapper::toDTO)
                .orElse(null);
    }

    public SupportDTO updateSupport(Long id, SupportDTO dto) {
        return supportRepository.findById(id)
                .map(existing -> {
                    existing.setTypeSupport(dto.getTypeSupport());
                    existing.setTitre(dto.getTitre());
                    existing.setUrl(dto.getUrl());
                    existing.setDateAjout(dto.getDateAjout());

                    if (dto.getFormationId() != null) {
                        formationRepository.findById(dto.getFormationId())
                                .ifPresent(existing::setFormation);
                    }

                    Support updated = supportRepository.save(existing);
                    return supportMapper.toDTO(updated);
                }).orElse(null);
    }

    public boolean deleteSupport(Long id) {
        if (supportRepository.existsById(id)) {
            supportRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

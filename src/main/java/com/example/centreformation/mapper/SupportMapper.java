package com.example.centreformation.mapper;

import com.example.centreformation.dto.SupportDTO;
import com.example.centreformation.entity.Formation;
import com.example.centreformation.entity.Support;
import com.example.centreformation.repository.FormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SupportMapper {

    @Autowired
    private FormationRepository formationRepository;

    public SupportDTO toDTO(Support support) {
        if (support == null) return null;
        return new SupportDTO(
                support.getId(),
                support.getFormation() != null ? support.getFormation().getId() : null,
                support.getTypeSupport(),
                support.getTitre(),
                support.getUrl(),
                support.getDateAjout()
        );
    }

    public Support toEntity(SupportDTO dto) {
        if (dto == null) return null;
        Support support = new Support();
        support.setId(dto.getId());
        support.setTypeSupport(dto.getTypeSupport());
        support.setTitre(dto.getTitre());
        support.setUrl(dto.getUrl());
        support.setDateAjout(dto.getDateAjout());

        if (dto.getFormationId() != null) {
            Formation formation = formationRepository.findById(dto.getFormationId()).orElse(null);
            support.setFormation(formation);
        } else {
            support.setFormation(null);
        }
        return support;
    }
}

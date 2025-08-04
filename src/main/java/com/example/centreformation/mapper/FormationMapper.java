package com.example.centreformation.mapper;

import com.example.centreformation.dto.FormationDTO;
import com.example.centreformation.entity.Formation;

public class FormationMapper {

    public static FormationDTO toDTO(Formation formation) {
        return new FormationDTO(
                formation.getId(),
                formation.getTitre(),
                formation.getDescription(),
                formation.getDureeHeures(),
                formation.getLogicielCible(),
                formation.getDateCreation()
        );
    }

    public static Formation toEntity(FormationDTO dto) {
        Formation formation = new Formation();
        formation.setId(dto.getId());
        formation.setTitre(dto.getTitre());
        formation.setDescription(dto.getDescription());
        formation.setDureeHeures(dto.getDureeHeures());
        formation.setLogicielCible(dto.getLogicielCible());
        formation.setDateCreation(dto.getDateCreation());
        return formation;
    }
}

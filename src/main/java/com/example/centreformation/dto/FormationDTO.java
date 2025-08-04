package com.example.centreformation.dto;

import java.time.LocalDate;

public class FormationDTO {
    private Long id;
    private String titre;
    private String description;
    private int dureeHeures;
    private String logicielCible;
    private LocalDate dateCreation;

    public FormationDTO() {}

    public FormationDTO(Long id, String titre, String description, int dureeHeures, String logicielCible, LocalDate dateCreation) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.dureeHeures = dureeHeures;
        this.logicielCible = logicielCible;
        this.dateCreation = dateCreation;
    }

    // Getters & Setters

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitre() {
        return titre;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getDureeHeures() {
        return dureeHeures;
    }
    public void setDureeHeures(int dureeHeures) {
        this.dureeHeures = dureeHeures;
    }
    public String getLogicielCible() {
        return logicielCible;
    }
    public void setLogicielCible(String logicielCible) {
        this.logicielCible = logicielCible;
    }
    public LocalDate getDateCreation() {
        return dateCreation;
    }
    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }
}

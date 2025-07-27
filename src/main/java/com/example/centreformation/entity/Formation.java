package com.example.centreformation.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "formations")
public class Formation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;

    private String description;

    @Column(name = "duree_heures")
    private int dureeHeures;

    @Column(name = "logiciel_cible")
    private String logicielCible;

    @Column(name = "date_creation")
    private LocalDate dateCreation;

    // Constructor vide
    public Formation() {
    }

    // Constructor avec tous les champs sauf id
    public Formation(String titre, String description, int dureeHeures, String logicielCible, LocalDate dateCreation) {
        this.titre = titre;
        this.description = description;
        this.dureeHeures = dureeHeures;
        this.logicielCible = logicielCible;
        this.dateCreation = dateCreation;
    }

    // Getters et setters

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

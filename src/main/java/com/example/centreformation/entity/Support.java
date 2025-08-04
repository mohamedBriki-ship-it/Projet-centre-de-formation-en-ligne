package com.example.centreformation.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "supports")
public class Support {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "formation_id", nullable = false)
    private Formation formation;

    @Column(name = "type_support", nullable = false)
    private String typeSupport;

    @Column(nullable = false)
    private String titre;

    @Column(nullable = false)
    private String url;

    @Column(name = "date_ajout", nullable = false)
    private LocalDate dateAjout;

    public Support() {}

    public Support(Formation formation, String typeSupport, String titre, String url, LocalDate dateAjout) {
        this.formation = formation;
        this.typeSupport = typeSupport;
        this.titre = titre;
        this.url = url;
        this.dateAjout = dateAjout;
    }

    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    public String getTypeSupport() {
        return typeSupport;
    }

    public void setTypeSupport(String typeSupport) {
        this.typeSupport = typeSupport;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalDate getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(LocalDate dateAjout) {
        this.dateAjout = dateAjout;
    }
}

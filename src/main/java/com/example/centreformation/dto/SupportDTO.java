package com.example.centreformation.dto;

import java.time.LocalDate;

public class SupportDTO {

    private Long id;
    private Long formationId;  // نبعثوا ID متاع formation
    private String typeSupport;
    private String titre;
    private String url;
    private LocalDate dateAjout;

    public SupportDTO() {}

    public SupportDTO(Long id, Long formationId, String typeSupport, String titre, String url, LocalDate dateAjout) {
        this.id = id;
        this.formationId = formationId;
        this.typeSupport = typeSupport;
        this.titre = titre;
        this.url = url;
        this.dateAjout = dateAjout;
    }

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getFormationId() { return formationId; }
    public void setFormationId(Long formationId) { this.formationId = formationId; }

    public String getTypeSupport() { return typeSupport; }
    public void setTypeSupport(String typeSupport) { this.typeSupport = typeSupport; }

    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public LocalDate getDateAjout() { return dateAjout; }
    public void setDateAjout(LocalDate dateAjout) { this.dateAjout = dateAjout; }
}

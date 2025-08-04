package com.example.centreformation.dto;

import java.time.LocalDate;

public class InscriptionDTO {

    private Long id;

    private Long userId;

    private Long formationId;

    private LocalDate dateInscription;

    private String statutPaiement;

    // Constructors
    public InscriptionDTO() {}

    public InscriptionDTO(Long id, Long userId, Long formationId, LocalDate dateInscription, String statutPaiement) {
        this.id = id;
        this.userId = userId;
        this.formationId = formationId;
        this.dateInscription = dateInscription;
        this.statutPaiement = statutPaiement;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Long getFormationId() { return formationId; }
    public void setFormationId(Long formationId) { this.formationId = formationId; }

    public LocalDate getDateInscription() { return dateInscription; }
    public void setDateInscription(LocalDate dateInscription) { this.dateInscription = dateInscription; }

    public String getStatutPaiement() { return statutPaiement; }
    public void setStatutPaiement(String statutPaiement) { this.statutPaiement = statutPaiement; }
}

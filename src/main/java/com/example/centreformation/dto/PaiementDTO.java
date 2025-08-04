package com.example.centreformation.dto;

import java.time.LocalDate;

public class PaiementDTO {

    private Long id;
    private Long inscriptionId;  // فقط نبعث الـ id متاع inscription
    private Double montant;
    private LocalDate datePaiement;
    private String methodePaiement;
    private String statut;

    public PaiementDTO() {}

    public PaiementDTO(Long id, Long inscriptionId, Double montant, LocalDate datePaiement, String methodePaiement, String statut) {
        this.id = id;
        this.inscriptionId = inscriptionId;
        this.montant = montant;
        this.datePaiement = datePaiement;
        this.methodePaiement = methodePaiement;
        this.statut = statut;
    }

    // getters and setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getInscriptionId() { return inscriptionId; }
    public void setInscriptionId(Long inscriptionId) { this.inscriptionId = inscriptionId; }

    public Double getMontant() { return montant; }
    public void setMontant(Double montant) { this.montant = montant; }

    public LocalDate getDatePaiement() { return datePaiement; }
    public void setDatePaiement(LocalDate datePaiement) { this.datePaiement = datePaiement; }

    public String getMethodePaiement() { return methodePaiement; }
    public void setMethodePaiement(String methodePaiement) { this.methodePaiement = methodePaiement; }

    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }
}

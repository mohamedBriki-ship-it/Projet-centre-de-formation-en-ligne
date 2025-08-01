package com.example.centreformation.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "inscriptions")
public class Inscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Association avec User
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Association avec Formation
    @ManyToOne
    @JoinColumn(name = "formation_id", nullable = false)
    private Formation formation;

    @Column(name = "date_inscription")
    private LocalDate dateInscription;

    @Column(name = "statut_paiement")
    private String statutPaiement; // Exemple: "payé", "en attente", "non payé"

    // ===== Constructors =====
    public Inscription() {}

    public Inscription(User user, Formation formation, LocalDate dateInscription, String statutPaiement) {
        this.user = user;
        this.formation = formation;
        this.dateInscription = dateInscription;
        this.statutPaiement = statutPaiement;
    }

    // ===== Getters and Setters =====

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    public LocalDate getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(LocalDate dateInscription) {
        this.dateInscription = dateInscription;
    }

    public String getStatutPaiement() {
        return statutPaiement;
    }

    public void setStatutPaiement(String statutPaiement) {
        this.statutPaiement = statutPaiement;
    }
}

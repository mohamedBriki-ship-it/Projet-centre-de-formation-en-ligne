package com.example.centreformation.repository;

import com.example.centreformation.entity.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscriptionRepository extends JpaRepository<Inscription, Long> {
    // tu peux ajouter des méthodes personnalisées ici si besoin
}

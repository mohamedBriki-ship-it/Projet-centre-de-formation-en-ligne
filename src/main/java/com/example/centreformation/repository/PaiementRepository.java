package com.example.centreformation.repository;

import com.example.centreformation.entity.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaiementRepository extends JpaRepository<Paiement, Long> {
    // تقدر تزيد دوال خاصة إذا تحب
}

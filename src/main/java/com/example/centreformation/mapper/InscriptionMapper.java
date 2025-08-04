package com.example.centreformation.mapper;

import com.example.centreformation.dto.InscriptionDTO;
import com.example.centreformation.entity.Formation;
import com.example.centreformation.entity.Inscription;
import com.example.centreformation.entity.User;
import org.springframework.stereotype.Component;

@Component
public class InscriptionMapper {

    public InscriptionDTO toDTO(Inscription inscription) {
        if (inscription == null) return null;
        return new InscriptionDTO(
                inscription.getId(),
                inscription.getUser() != null ? inscription.getUser().getId() : null,
                inscription.getFormation() != null ? inscription.getFormation().getId() : null,
                inscription.getDateInscription(),
                inscription.getStatutPaiement()
        );
    }

    public Inscription toEntity(InscriptionDTO dto, User user, Formation formation) {
        if (dto == null) return null;
        Inscription inscription = new Inscription();
        inscription.setId(dto.getId());
        inscription.setUser(user);
        inscription.setFormation(formation);
        inscription.setDateInscription(dto.getDateInscription());
        inscription.setStatutPaiement(dto.getStatutPaiement());
        return inscription;
    }
}

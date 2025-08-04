package com.example.centreformation.mapper;

import com.example.centreformation.dto.UserDTO;
import com.example.centreformation.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDTO toDTO(User user) {
        if (user == null) return null;
        return new UserDTO(
                user.getId(),
                user.getNom(),
                user.getPrenom(),
                user.getEmail(),
                user.getMotDePasse(),
                user.getRole() != null ? user.getRole().name() : null,
                user.getDateInscription()
        );
    }

    public User toEntity(UserDTO dto) {
        if (dto == null) return null;
        User user = new User();
        user.setId(dto.getId());
        user.setNom(dto.getNom());
        user.setPrenom(dto.getPrenom());
        user.setEmail(dto.getEmail());
        user.setMotDePasse(dto.getMotDePasse());
        if (dto.getRole() != null) {
            user.setRole(User.Role.valueOf(dto.getRole()));
        }
        user.setDateInscription(dto.getDateInscription());
        return user;
    }
}

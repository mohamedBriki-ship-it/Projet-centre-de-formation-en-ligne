package com.example.centreformation.service;

import com.example.centreformation.dto.UserDTO;
import com.example.centreformation.entity.User;
import com.example.centreformation.mapper.UserMapper;
import com.example.centreformation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper mapper;

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public UserDTO getUserById(Long id) {
        return userRepository.findById(id)
                .map(mapper::toDTO)
                .orElse(null);
    }

    public UserDTO saveUser(UserDTO dto) {
        User user = mapper.toEntity(dto);
        User saved = userRepository.save(user);
        return mapper.toDTO(saved);
    }

    public UserDTO updateUser(Long id, UserDTO dto) {
        return userRepository.findById(id).map(existing -> {
            existing.setNom(dto.getNom());
            existing.setPrenom(dto.getPrenom());
            existing.setEmail(dto.getEmail());
            existing.setMotDePasse(dto.getMotDePasse());
            if (dto.getRole() != null) {
                existing.setRole(User.Role.valueOf(dto.getRole()));
            }
            existing.setDateInscription(dto.getDateInscription());
            User updated = userRepository.save(existing);
            return mapper.toDTO(updated);
        }).orElse(null);
    }

    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

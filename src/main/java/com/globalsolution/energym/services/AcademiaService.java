package com.globalsolution.energym.services;

import com.globalsolution.energym.domain.entities.Academia;
import com.globalsolution.energym.dto.AcademiaCreateDTO;
import com.globalsolution.energym.repositories.AcademiaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AcademiaService {

    @Autowired
    private AcademiaRepository repository;

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @Transactional
    public Academia saveNewAcademia(AcademiaCreateDTO academiaCreateDTO){
        return repository.save(new Academia(
                null,
                academiaCreateDTO.getCnpj(),
                academiaCreateDTO.getNome(),
                academiaCreateDTO.getUser(),
                enderecoService.save(academiaCreateDTO.getEndereco())
        ));
    }

    public Academia findByUserId(Long id) {
        return repository.findByUserId(id).orElseThrow(() -> new EntityNotFoundException("Academia não encontrada para o userId: " + id));
    }

    public Academia findById(Long academiaId) {
        return repository.findById(academiaId).orElseThrow(() -> new EntityNotFoundException("Academia não encontrada para o id:" + academiaId));
    }

    @Transactional
    public Academia update(AcademiaCreateDTO academiaCreateDTO, Long id){
        Academia academia = findById(id);
        academia.updateData(academiaCreateDTO);
        academia.getEndereco().updateData(academiaCreateDTO.getEndereco());
        academia.getUser().setUsername(academiaCreateDTO.getUser().getUsername());
        academia.getUser().setEmail(academiaCreateDTO.getUser().getEmail());
        academia.getUser().setPassword(passwordEncoder.encode(academiaCreateDTO.getUser().getPassword()));
        enderecoService.save(academia.getEndereco());
        userService.save(academia.getUser());
        return repository.save(academia);
    }
}

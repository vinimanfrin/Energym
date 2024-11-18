package com.globalsolution.energym.services;

import com.globalsolution.energym.domain.entities.Academia;
import com.globalsolution.energym.domain.entities.Exercicio;
import com.globalsolution.energym.repositories.ExercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ExercicioService {

    @Autowired
    private ExercicioRepository repository;

    @Autowired
    private UserService userService;

    @Autowired
    private AcademiaService academiaService;

    public Page<Exercicio> getPageExercicios(int page, int size) {
        Academia academiaAutenticada = academiaService.findByUserId(userService.authenticated().getId());
        Pageable pageable = PageRequest.of(page, size);
        return repository.findAllByAcademiaId(pageable,academiaAutenticada.getId());
    }
}

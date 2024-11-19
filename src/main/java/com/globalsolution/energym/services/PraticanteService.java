package com.globalsolution.energym.services;

import com.globalsolution.energym.domain.entities.Praticante;
import com.globalsolution.energym.repositories.PraticanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PraticanteService {

    @Autowired
    private PraticanteRepository repository;


    public Praticante buscarPorCpf(String cpf) {
        Optional<Praticante> praticante = repository.findByCpf(cpf);
        return praticante.orElse(null);
    }
}

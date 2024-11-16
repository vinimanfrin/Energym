package com.globalsolution.energym.services;

import com.globalsolution.energym.domain.entities.Endereco;
import com.globalsolution.energym.dto.EnderecoCreateDTO;
import com.globalsolution.energym.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    public Endereco save(EnderecoCreateDTO enderecoCreateDTO){
        return repository.save(new Endereco(
                null,
                enderecoCreateDTO.getNumero(),
                enderecoCreateDTO.getRua(),
                enderecoCreateDTO.getBairro(),
                enderecoCreateDTO.getCidade(),
                enderecoCreateDTO.getEstado(),
                enderecoCreateDTO.getCep()
        ));
    }
}

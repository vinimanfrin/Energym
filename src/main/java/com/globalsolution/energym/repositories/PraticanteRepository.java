package com.globalsolution.energym.repositories;

import com.globalsolution.energym.domain.entities.Praticante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PraticanteRepository extends JpaRepository<Praticante,Long> {
    Optional<Praticante> findByCpf(String cpf);
}

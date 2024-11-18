package com.globalsolution.energym.repositories;

import com.globalsolution.energym.domain.entities.Praticante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PraticanteRepository extends JpaRepository<Praticante,Long> {
}

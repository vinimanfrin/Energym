package com.globalsolution.energym.repositories;

import com.globalsolution.energym.domain.entities.Exercicio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExercicioRepository extends JpaRepository<Exercicio,Long> {
    Page<Exercicio> findAllByAcademiaId(Pageable pageable, Long academiaId);
}

package com.globalsolution.energym.repositories;

import com.globalsolution.energym.domain.entities.Academia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademiaRepository extends JpaRepository<Academia,Long> {
}

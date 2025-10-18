package com.morningvalue.infrastructure.persistence.repository;

import com.morningvalue.infrastructure.persistence.entity.SpeciesJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeciesJpaRepository extends JpaRepository<SpeciesJpaEntity, Long> {
    boolean existsByName(String name);
}

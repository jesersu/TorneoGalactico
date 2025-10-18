package com.morningvalue.domain.repository;

import com.morningvalue.domain.entity.Species;

import java.util.List;
import java.util.Optional;

public interface SpeciesRepository {
    Species save(Species species);
    Optional<Species> findById(Long id);
    List<Species> findAll();
    void deleteById(Long id);
    boolean existsByName(String name);
}

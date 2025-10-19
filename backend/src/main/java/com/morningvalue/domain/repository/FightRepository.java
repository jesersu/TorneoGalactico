package com.morningvalue.domain.repository;

import com.morningvalue.domain.entity.Fight;

import java.util.List;
import java.util.Optional;

public interface FightRepository {
    Fight save(Fight fight);
    Optional<Fight> findById(Long id);
    List<Fight> findAll();
    List<Fight> findBySpeciesId(Long speciesId);
}

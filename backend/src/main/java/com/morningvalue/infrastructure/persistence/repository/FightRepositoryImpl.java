package com.morningvalue.infrastructure.persistence.repository;

import com.morningvalue.domain.entity.Fight;
import com.morningvalue.domain.repository.FightRepository;
import com.morningvalue.infrastructure.persistence.mapper.FightMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class FightRepositoryImpl implements FightRepository {
    private final FightJpaRepository jpaRepository;
    private final FightMapper mapper;

    public FightRepositoryImpl(FightJpaRepository jpaRepository, FightMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Fight save(Fight fight) {
        return mapper.toDomain(jpaRepository.save(mapper.toEntity(fight)));
    }

    @Override
    public Optional<Fight> findById(Long id) {
        return jpaRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<Fight> findAll() {
        return jpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Fight> findBySpeciesId(Long speciesId) {
        return jpaRepository.findBySpeciesId(speciesId).stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Long countVictoriesBySpeciesId(Long speciesId) {
        return jpaRepository.countVictoriesBySpeciesId(speciesId);
    }
}

package com.morningvalue.infrastructure.persistence.repository;

import com.morningvalue.domain.entity.Species;
import com.morningvalue.domain.repository.SpeciesRepository;
import com.morningvalue.infrastructure.persistence.mapper.SpeciesMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class SpeciesRepositoryImpl implements SpeciesRepository {
    private final SpeciesJpaRepository jpaRepository;
    private final SpeciesMapper mapper;

    public SpeciesRepositoryImpl(SpeciesJpaRepository jpaRepository, SpeciesMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Species save(Species species) {
        return mapper.toDomain(jpaRepository.save(mapper.toEntity(species)));
    }

    @Override
    public Optional<Species> findById(Long id) {
        return jpaRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<Species> findAll() {
        return jpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public boolean existsByName(String name) {
        return jpaRepository.existsByName(name);
    }
}

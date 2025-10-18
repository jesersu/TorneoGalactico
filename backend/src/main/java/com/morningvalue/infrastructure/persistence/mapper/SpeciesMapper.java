package com.morningvalue.infrastructure.persistence.mapper;

import com.morningvalue.domain.entity.Species;
import com.morningvalue.infrastructure.persistence.entity.SpeciesJpaEntity;
import org.springframework.stereotype.Component;

@Component
public class SpeciesMapper {
    public Species toDomain(SpeciesJpaEntity entity) {
        if (entity == null) {
            return null;
        }
        return new Species(
                entity.getId(),
                entity.getName(),
                entity.getPowerLevel(),
                entity.getSpecialPower()
        );
    }

    public SpeciesJpaEntity toEntity(Species domain) {
        if (domain == null) {
            return null;
        }
        return new SpeciesJpaEntity(
                domain.getId(),
                domain.getName(),
                domain.getPowerLevel(),
                domain.getSpecialPower()
        );
    }
}

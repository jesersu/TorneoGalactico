package com.morningvalue.infrastructure.persistence.mapper;

import com.morningvalue.domain.entity.Fight;
import com.morningvalue.infrastructure.persistence.entity.FightJpaEntity;
import org.springframework.stereotype.Component;

@Component
public class FightMapper {
    private final SpeciesMapper speciesMapper;

    public FightMapper(SpeciesMapper speciesMapper) {
        this.speciesMapper = speciesMapper;
    }

    public Fight toDomain(FightJpaEntity entity) {
        if (entity == null) {
            return null;
        }
        return new Fight(
                entity.getId(),
                speciesMapper.toDomain(entity.getSpecies1()),
                speciesMapper.toDomain(entity.getSpecies2()),
                speciesMapper.toDomain(entity.getWinner()),
                entity.getFightDate(),
                entity.getBattleDescription()
        );
    }

    public FightJpaEntity toEntity(Fight domain) {
        if (domain == null) {
            return null;
        }
        return new FightJpaEntity(
                domain.getId(),
                speciesMapper.toEntity(domain.getSpecies1()),
                speciesMapper.toEntity(domain.getSpecies2()),
                speciesMapper.toEntity(domain.getWinner()),
                domain.getFightDate(),
                domain.getBattleDescription()
        );
    }
}

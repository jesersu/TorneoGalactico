package com.morningvalue.infrastructure.persistence.repository;

import com.morningvalue.infrastructure.persistence.entity.FightJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FightJpaRepository extends JpaRepository<FightJpaEntity, Long> {
    @Query("SELECT f FROM FightJpaEntity f WHERE f.species1.id = :speciesId OR f.species2.id = :speciesId")
    List<FightJpaEntity> findBySpeciesId(@Param("speciesId") Long speciesId);

    @Query("SELECT COUNT(f) FROM FightJpaEntity f WHERE f.winner.id = :speciesId")
    Long countVictoriesBySpeciesId(@Param("speciesId") Long speciesId);
}

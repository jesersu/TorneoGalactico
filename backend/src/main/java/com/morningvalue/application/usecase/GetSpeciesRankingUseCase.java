package com.morningvalue.application.usecase;

import com.morningvalue.domain.entity.Species;
import com.morningvalue.domain.repository.FightRepository;
import com.morningvalue.domain.repository.SpeciesRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class GetSpeciesRankingUseCase {
    private final SpeciesRepository speciesRepository;
    private final FightRepository fightRepository;

    public GetSpeciesRankingUseCase(SpeciesRepository speciesRepository, FightRepository fightRepository) {
        this.speciesRepository = speciesRepository;
        this.fightRepository = fightRepository;
    }

    public Map<Species, Long> execute() {
        List<Species> allSpecies = speciesRepository.findAll();
        Map<Species, Long> ranking = new HashMap<>();

        for (Species species : allSpecies) {
            Long victories = fightRepository.countVictoriesBySpeciesId(species.getId());
            ranking.put(species, victories);
        }

        return ranking;
    }
}

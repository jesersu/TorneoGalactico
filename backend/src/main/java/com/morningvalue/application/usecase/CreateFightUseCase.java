package com.morningvalue.application.usecase;

import com.morningvalue.domain.entity.Fight;
import com.morningvalue.domain.entity.Species;
import com.morningvalue.domain.exception.InvalidFightException;
import com.morningvalue.domain.exception.SpeciesNotFoundException;
import com.morningvalue.domain.repository.FightRepository;
import com.morningvalue.domain.repository.SpeciesRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Random;

@Component
public class CreateFightUseCase {
    private final FightRepository fightRepository;
    private final SpeciesRepository speciesRepository;
    private final Random random = new Random();

    public CreateFightUseCase(FightRepository fightRepository, SpeciesRepository speciesRepository) {
        this.fightRepository = fightRepository;
        this.speciesRepository = speciesRepository;
    }

    public Fight execute(Long species1Id, Long species2Id) {
        if (species1Id.equals(species2Id)) {
            throw new InvalidFightException("A species cannot fight itself");
        }

        Species species1 = speciesRepository.findById(species1Id)
                .orElseThrow(() -> new SpeciesNotFoundException(species1Id));
        Species species2 = speciesRepository.findById(species2Id)
                .orElseThrow(() -> new SpeciesNotFoundException(species2Id));

        Species winner = determineWinner(species1, species2);
        String battleDescription = generateBattleDescription(species1, species2, winner);

        Fight fight = new Fight();
        fight.setSpecies1(species1);
        fight.setSpecies2(species2);
        fight.setWinner(winner);
        fight.setFightDate(LocalDateTime.now());
        fight.setBattleDescription(battleDescription);

        return fightRepository.save(fight);
    }

    private Species determineWinner(Species species1, Species species2) {
        int powerDifference = species1.getPowerLevel() - species2.getPowerLevel();

        // Base probability based on power difference
        double species1WinProbability = 0.5 + (powerDifference * 0.05);

        // Clamp probability between 0.1 and 0.9 to give underdogs a chance
        species1WinProbability = Math.max(0.1, Math.min(0.9, species1WinProbability));

        return random.nextDouble() < species1WinProbability ? species1 : species2;
    }

    private String generateBattleDescription(Species species1, Species species2, Species winner) {
        String loser = winner.getId().equals(species1.getId()) ? species2.getName() : species1.getName();
        return String.format("%s used %s to defeat %s in an epic battle!",
                winner.getName(), winner.getSpecialPower(), loser);
    }
}

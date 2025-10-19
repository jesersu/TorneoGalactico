package com.morningvalue.application.service;

import com.morningvalue.application.dto.CreateFightRequest;
import com.morningvalue.application.dto.FightDTO;
import com.morningvalue.application.dto.SpeciesDTO;
import com.morningvalue.application.usecase.CreateFightUseCase;
import com.morningvalue.domain.entity.Fight;
import com.morningvalue.domain.entity.Species;
import org.springframework.stereotype.Service;

@Service
public class FightService {
    private final CreateFightUseCase createFightUseCase;

    public FightService(CreateFightUseCase createFightUseCase) {
        this.createFightUseCase = createFightUseCase;
    }

    public FightDTO createFight(CreateFightRequest request) {
        Fight fight = createFightUseCase.execute(
                request.getSpecies1Id(),
                request.getSpecies2Id()
        );
        return toDTO(fight);
    }

    private FightDTO toDTO(Fight fight) {
        return new FightDTO(
                fight.getId(),
                toSpeciesDTO(fight.getSpecies1()),
                toSpeciesDTO(fight.getSpecies2()),
                toSpeciesDTO(fight.getWinner()),
                fight.getFightDate(),
                fight.getBattleDescription()
        );
    }

    private SpeciesDTO toSpeciesDTO(Species species) {
        return new SpeciesDTO(
                species.getId(),
                species.getName(),
                species.getPowerLevel(),
                species.getSpecialPower()
        );
    }
}

package com.morningvalue.application.service;

import com.morningvalue.application.dto.CreateFightRequest;
import com.morningvalue.application.dto.FightDTO;
import com.morningvalue.application.dto.SpeciesDTO;
import com.morningvalue.application.usecase.CreateFightUseCase;
import com.morningvalue.application.usecase.GetAllFightsUseCase;
import com.morningvalue.domain.entity.Fight;
import com.morningvalue.domain.entity.Species;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FightService {
    private final CreateFightUseCase createFightUseCase;
    private final GetAllFightsUseCase getAllFightsUseCase;

    public FightService(CreateFightUseCase createFightUseCase, GetAllFightsUseCase getAllFightsUseCase) {
        this.createFightUseCase = createFightUseCase;
        this.getAllFightsUseCase = getAllFightsUseCase;
    }

    public FightDTO createFight(CreateFightRequest request) {
        Fight fight = createFightUseCase.execute(
                request.getSpecies1Id(),
                request.getSpecies2Id()
        );
        return toDTO(fight);
    }

    public List<FightDTO> getAllFights() {
        List<Fight> fights = getAllFightsUseCase.execute();
        return fights.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
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

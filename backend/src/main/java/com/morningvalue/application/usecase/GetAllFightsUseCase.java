package com.morningvalue.application.usecase;

import com.morningvalue.domain.entity.Fight;
import com.morningvalue.domain.repository.FightRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllFightsUseCase {
    private final FightRepository fightRepository;

    public GetAllFightsUseCase(FightRepository fightRepository) {
        this.fightRepository = fightRepository;
    }

    public List<Fight> execute() {
        return fightRepository.findAll();
    }
}

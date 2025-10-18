package com.morningvalue.application.usecase;

import com.morningvalue.domain.entity.Species;
import com.morningvalue.domain.repository.SpeciesRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllSpeciesUseCase {
    private final SpeciesRepository speciesRepository;

    public GetAllSpeciesUseCase(SpeciesRepository speciesRepository) {
        this.speciesRepository = speciesRepository;
    }

    public List<Species> execute() {
        return speciesRepository.findAll();
    }
}

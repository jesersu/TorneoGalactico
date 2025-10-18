package com.morningvalue.application.usecase;

import com.morningvalue.domain.entity.Species;
import com.morningvalue.domain.exception.SpeciesAlreadyExistsException;
import com.morningvalue.domain.repository.SpeciesRepository;
import org.springframework.stereotype.Component;

@Component
public class CreateSpeciesUseCase {
    private final SpeciesRepository speciesRepository;

    public CreateSpeciesUseCase(SpeciesRepository speciesRepository) {
        this.speciesRepository = speciesRepository;
    }

    public Species execute(String name, Integer powerLevel, String specialPower) {
        if (speciesRepository.existsByName(name)) {
            throw new SpeciesAlreadyExistsException(name);
        }

        Species species = new Species();
        species.setName(name);
        species.setPowerLevel(powerLevel);
        species.setSpecialPower(specialPower);

        return speciesRepository.save(species);
    }
}

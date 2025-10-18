package com.morningvalue.application.usecase;

import com.morningvalue.domain.entity.Species;
import com.morningvalue.domain.exception.SpeciesNotFoundException;
import com.morningvalue.domain.repository.SpeciesRepository;
import org.springframework.stereotype.Component;

@Component
public class GetSpeciesByIdUseCase {
    private final SpeciesRepository speciesRepository;

    public GetSpeciesByIdUseCase(SpeciesRepository speciesRepository) {
        this.speciesRepository = speciesRepository;
    }

    public Species execute(Long id) {
        return speciesRepository.findById(id)
                .orElseThrow(() -> new SpeciesNotFoundException(id));
    }
}

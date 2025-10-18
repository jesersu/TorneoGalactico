package com.morningvalue.application.service;

import com.morningvalue.application.dto.CreateSpeciesRequest;
import com.morningvalue.application.dto.SpeciesDTO;
import com.morningvalue.application.usecase.CreateSpeciesUseCase;
import com.morningvalue.application.usecase.GetAllSpeciesUseCase;
import com.morningvalue.application.usecase.GetSpeciesByIdUseCase;
import com.morningvalue.domain.entity.Species;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpeciesService {
    private final CreateSpeciesUseCase createSpeciesUseCase;
    private final GetAllSpeciesUseCase getAllSpeciesUseCase;
    private final GetSpeciesByIdUseCase getSpeciesByIdUseCase;

    public SpeciesService(CreateSpeciesUseCase createSpeciesUseCase,
                          GetAllSpeciesUseCase getAllSpeciesUseCase,
                          GetSpeciesByIdUseCase getSpeciesByIdUseCase) {
        this.createSpeciesUseCase = createSpeciesUseCase;
        this.getAllSpeciesUseCase = getAllSpeciesUseCase;
        this.getSpeciesByIdUseCase = getSpeciesByIdUseCase;
    }

    public SpeciesDTO createSpecies(CreateSpeciesRequest request) {
        Species species = createSpeciesUseCase.execute(
                request.getName(),
                request.getPowerLevel(),
                request.getSpecialPower()
        );
        return toDTO(species);
    }

    public List<SpeciesDTO> getAllSpecies() {
        return getAllSpeciesUseCase.execute().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public SpeciesDTO getSpeciesById(Long id) {
        Species species = getSpeciesByIdUseCase.execute(id);
        return toDTO(species);
    }

    private SpeciesDTO toDTO(Species species) {
        return new SpeciesDTO(
                species.getId(),
                species.getName(),
                species.getPowerLevel(),
                species.getSpecialPower()
        );
    }
}

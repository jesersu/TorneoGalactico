package com.morningvalue.application.service;

import com.morningvalue.application.dto.CreateSpeciesRequest;
import com.morningvalue.application.dto.SpeciesDTO;
import com.morningvalue.application.dto.SpeciesRankingDTO;
import com.morningvalue.application.usecase.CreateSpeciesUseCase;
import com.morningvalue.application.usecase.GetAllSpeciesUseCase;
import com.morningvalue.application.usecase.GetSpeciesByIdUseCase;
import com.morningvalue.application.usecase.GetSpeciesRankingUseCase;
import com.morningvalue.domain.entity.Species;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SpeciesService {
    private final CreateSpeciesUseCase createSpeciesUseCase;
    private final GetAllSpeciesUseCase getAllSpeciesUseCase;
    private final GetSpeciesByIdUseCase getSpeciesByIdUseCase;
    private final GetSpeciesRankingUseCase getSpeciesRankingUseCase;

    public SpeciesService(CreateSpeciesUseCase createSpeciesUseCase,
                          GetAllSpeciesUseCase getAllSpeciesUseCase,
                          GetSpeciesByIdUseCase getSpeciesByIdUseCase,
                          GetSpeciesRankingUseCase getSpeciesRankingUseCase) {
        this.createSpeciesUseCase = createSpeciesUseCase;
        this.getAllSpeciesUseCase = getAllSpeciesUseCase;
        this.getSpeciesByIdUseCase = getSpeciesByIdUseCase;
        this.getSpeciesRankingUseCase = getSpeciesRankingUseCase;
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

    public List<SpeciesRankingDTO> getSpeciesRanking() {
        Map<Species, Long> ranking = getSpeciesRankingUseCase.execute();

        return ranking.entrySet().stream()
                .map(entry -> toRankingDTO(entry.getKey(), entry.getValue()))
                .sorted(Comparator.comparing(SpeciesRankingDTO::getVictories).reversed())
                .collect(Collectors.toList());
    }

    private SpeciesDTO toDTO(Species species) {
        return new SpeciesDTO(
                species.getId(),
                species.getName(),
                species.getPowerLevel(),
                species.getSpecialPower()
        );
    }

    private SpeciesRankingDTO toRankingDTO(Species species, Long victories) {
        return new SpeciesRankingDTO(
                species.getId(),
                species.getName(),
                species.getPowerLevel(),
                species.getSpecialPower(),
                victories
        );
    }
}

package com.morningvalue.application.usecase;

import com.morningvalue.domain.entity.Fight;
import com.morningvalue.domain.entity.Species;
import com.morningvalue.domain.exception.InvalidFightException;
import com.morningvalue.domain.exception.SpeciesNotFoundException;
import com.morningvalue.domain.repository.FightRepository;
import com.morningvalue.domain.repository.SpeciesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CreateFightUseCaseTest {

    @Mock
    private FightRepository fightRepository;

    @Mock
    private SpeciesRepository speciesRepository;

    private CreateFightUseCase createFightUseCase;

    @BeforeEach
    void setUp() {
        createFightUseCase = new CreateFightUseCase(fightRepository, speciesRepository);
    }

    @Test
    void shouldCreateFightSuccessfully() {
        // Given
        Species species1 = new Species(1L, "Dragon", 9000, "Fire breath");
        Species species2 = new Species(2L, "Phoenix", 8500, "Resurrection");

        when(speciesRepository.findById(1L)).thenReturn(Optional.of(species1));
        when(speciesRepository.findById(2L)).thenReturn(Optional.of(species2));
        when(fightRepository.save(any(Fight.class))).thenAnswer(invocation -> {
            Fight fight = invocation.getArgument(0);
            fight.setId(1L);
            return fight;
        });

        // When
        Fight result = createFightUseCase.execute(1L, 2L);

        // Then
        assertNotNull(result);
        assertNotNull(result.getId());
        assertEquals(species1, result.getSpecies1());
        assertEquals(species2, result.getSpecies2());
        assertNotNull(result.getWinner());
        assertNotNull(result.getFightDate());
        assertNotNull(result.getBattleDescription());

        verify(speciesRepository).findById(1L);
        verify(speciesRepository).findById(2L);
        verify(fightRepository).save(any(Fight.class));
    }

    @Test
    void shouldThrowExceptionWhenSpeciesFightsItself() {
        // When & Then
        assertThrows(InvalidFightException.class, () ->
                createFightUseCase.execute(1L, 1L)
        );

        verify(fightRepository, never()).save(any(Fight.class));
    }

    @Test
    void shouldThrowExceptionWhenSpecies1NotFound() {
        // Given
        when(speciesRepository.findById(1L)).thenReturn(Optional.empty());

        // When & Then
        assertThrows(SpeciesNotFoundException.class, () ->
                createFightUseCase.execute(1L, 2L)
        );

        verify(fightRepository, never()).save(any(Fight.class));
    }

    @Test
    void shouldThrowExceptionWhenSpecies2NotFound() {
        // Given
        Species species1 = new Species(1L, "Dragon", 9000, "Fire breath");
        when(speciesRepository.findById(1L)).thenReturn(Optional.of(species1));
        when(speciesRepository.findById(2L)).thenReturn(Optional.empty());

        // When & Then
        assertThrows(SpeciesNotFoundException.class, () ->
                createFightUseCase.execute(1L, 2L)
        );

        verify(fightRepository, never()).save(any(Fight.class));
    }
}

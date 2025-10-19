package com.morningvalue.application.usecase;

import com.morningvalue.domain.entity.Species;
import com.morningvalue.domain.exception.SpeciesAlreadyExistsException;
import com.morningvalue.domain.repository.SpeciesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CreateSpeciesUseCaseTest {

    @Mock
    private SpeciesRepository speciesRepository;

    private CreateSpeciesUseCase createSpeciesUseCase;

    @BeforeEach
    void setUp() {
        createSpeciesUseCase = new CreateSpeciesUseCase(speciesRepository);
    }

    @Test
    void shouldCreateSpeciesSuccessfully() {
        // Given
        String name = "Dragon";
        Integer powerLevel = 9000;
        String specialPower = "Fire breath";

        Species savedSpecies = new Species(1L, name, powerLevel, specialPower);
        when(speciesRepository.existsByName(name)).thenReturn(false);
        when(speciesRepository.save(any(Species.class))).thenReturn(savedSpecies);

        // When
        Species result = createSpeciesUseCase.execute(name, powerLevel, specialPower);

        // Then
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals(name, result.getName());
        assertEquals(powerLevel, result.getPowerLevel());
        assertEquals(specialPower, result.getSpecialPower());

        verify(speciesRepository).existsByName(name);
        verify(speciesRepository).save(any(Species.class));
    }

    @Test
    void shouldThrowExceptionWhenSpeciesAlreadyExists() {
        // Given
        String name = "Dragon";
        Integer powerLevel = 9000;
        String specialPower = "Fire breath";

        when(speciesRepository.existsByName(name)).thenReturn(true);

        // When & Then
        assertThrows(SpeciesAlreadyExistsException.class, () ->
                createSpeciesUseCase.execute(name, powerLevel, specialPower)
        );

        verify(speciesRepository).existsByName(name);
        verify(speciesRepository, never()).save(any(Species.class));
    }
}

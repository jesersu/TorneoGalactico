package com.morningvalue.application.usecase;

import com.morningvalue.domain.entity.Species;
import com.morningvalue.domain.repository.SpeciesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GetAllSpeciesUseCaseTest {

    @Mock
    private SpeciesRepository speciesRepository;

    private GetAllSpeciesUseCase getAllSpeciesUseCase;

    @BeforeEach
    void setUp() {
        getAllSpeciesUseCase = new GetAllSpeciesUseCase(speciesRepository);
    }

    @Test
    void shouldReturnAllSpecies() {
        // Given
        Species species1 = new Species(1L, "Dragon", 9000, "Fire breath");
        Species species2 = new Species(2L, "Phoenix", 8500, "Resurrection");
        List<Species> speciesList = Arrays.asList(species1, species2);

        when(speciesRepository.findAll()).thenReturn(speciesList);

        // When
        List<Species> result = getAllSpeciesUseCase.execute();

        // Then
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Dragon", result.get(0).getName());
        assertEquals("Phoenix", result.get(1).getName());

        verify(speciesRepository).findAll();
    }

    @Test
    void shouldReturnEmptyListWhenNoSpeciesExist() {
        // Given
        when(speciesRepository.findAll()).thenReturn(Arrays.asList());

        // When
        List<Species> result = getAllSpeciesUseCase.execute();

        // Then
        assertNotNull(result);
        assertTrue(result.isEmpty());

        verify(speciesRepository).findAll();
    }
}

package com.morningvalue.presentation.controller;

import com.morningvalue.application.dto.CreateSpeciesRequest;
import com.morningvalue.application.dto.SpeciesDTO;
import com.morningvalue.application.service.SpeciesService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/species")
@CrossOrigin(origins = "http://localhost:3000")
public class SpeciesController {
    private final SpeciesService speciesService;

    public SpeciesController(SpeciesService speciesService) {
        this.speciesService = speciesService;
    }

    @PostMapping
    public ResponseEntity<SpeciesDTO> createSpecies(@Valid @RequestBody CreateSpeciesRequest request) {
        SpeciesDTO species = speciesService.createSpecies(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(species);
    }

    @GetMapping
    public ResponseEntity<List<SpeciesDTO>> getAllSpecies() {
        List<SpeciesDTO> species = speciesService.getAllSpecies();
        return ResponseEntity.ok(species);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SpeciesDTO> getSpeciesById(@PathVariable Long id) {
        SpeciesDTO species = speciesService.getSpeciesById(id);
        return ResponseEntity.ok(species);
    }
}

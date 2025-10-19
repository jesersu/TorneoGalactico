package com.morningvalue.presentation.controller;

import com.morningvalue.application.dto.CreateFightRequest;
import com.morningvalue.application.dto.FightDTO;
import com.morningvalue.application.service.FightService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fights")
@CrossOrigin(origins = "http://localhost:3000")
public class FightController {
    private final FightService fightService;

    public FightController(FightService fightService) {
        this.fightService = fightService;
    }

    @PostMapping
    public ResponseEntity<FightDTO> createFight(@Valid @RequestBody CreateFightRequest request) {
        FightDTO fight = fightService.createFight(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(fight);
    }
}

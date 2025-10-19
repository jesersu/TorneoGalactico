package com.morningvalue.application.dto;

import java.time.LocalDateTime;

public class FightDTO {
    private Long id;
    private SpeciesDTO species1;
    private SpeciesDTO species2;
    private SpeciesDTO winner;
    private LocalDateTime fightDate;
    private String battleDescription;

    public FightDTO() {
    }

    public FightDTO(Long id, SpeciesDTO species1, SpeciesDTO species2, SpeciesDTO winner, LocalDateTime fightDate, String battleDescription) {
        this.id = id;
        this.species1 = species1;
        this.species2 = species2;
        this.winner = winner;
        this.fightDate = fightDate;
        this.battleDescription = battleDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SpeciesDTO getSpecies1() {
        return species1;
    }

    public void setSpecies1(SpeciesDTO species1) {
        this.species1 = species1;
    }

    public SpeciesDTO getSpecies2() {
        return species2;
    }

    public void setSpecies2(SpeciesDTO species2) {
        this.species2 = species2;
    }

    public SpeciesDTO getWinner() {
        return winner;
    }

    public void setWinner(SpeciesDTO winner) {
        this.winner = winner;
    }

    public LocalDateTime getFightDate() {
        return fightDate;
    }

    public void setFightDate(LocalDateTime fightDate) {
        this.fightDate = fightDate;
    }

    public String getBattleDescription() {
        return battleDescription;
    }

    public void setBattleDescription(String battleDescription) {
        this.battleDescription = battleDescription;
    }
}

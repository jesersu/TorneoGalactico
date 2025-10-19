package com.morningvalue.domain.entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class Fight {
    private Long id;
    private Species species1;
    private Species species2;
    private Species winner;
    private LocalDateTime fightDate;
    private String battleDescription;

    public Fight() {
    }

    public Fight(Long id, Species species1, Species species2, Species winner, LocalDateTime fightDate, String battleDescription) {
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

    public Species getSpecies1() {
        return species1;
    }

    public void setSpecies1(Species species1) {
        this.species1 = species1;
    }

    public Species getSpecies2() {
        return species2;
    }

    public void setSpecies2(Species species2) {
        this.species2 = species2;
    }

    public Species getWinner() {
        return winner;
    }

    public void setWinner(Species winner) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fight fight = (Fight) o;
        return Objects.equals(id, fight.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Fight{" +
                "id=" + id +
                ", species1=" + species1 +
                ", species2=" + species2 +
                ", winner=" + winner +
                ", fightDate=" + fightDate +
                ", battleDescription='" + battleDescription + '\'' +
                '}';
    }
}

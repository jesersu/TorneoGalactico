package com.morningvalue.application.dto;

public class SpeciesRankingDTO {
    private Long id;
    private String name;
    private Integer powerLevel;
    private String specialPower;
    private Long victories;

    public SpeciesRankingDTO() {
    }

    public SpeciesRankingDTO(Long id, String name, Integer powerLevel, String specialPower, Long victories) {
        this.id = id;
        this.name = name;
        this.powerLevel = powerLevel;
        this.specialPower = specialPower;
        this.victories = victories;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPowerLevel() {
        return powerLevel;
    }

    public void setPowerLevel(Integer powerLevel) {
        this.powerLevel = powerLevel;
    }

    public String getSpecialPower() {
        return specialPower;
    }

    public void setSpecialPower(String specialPower) {
        this.specialPower = specialPower;
    }

    public Long getVictories() {
        return victories;
    }

    public void setVictories(Long victories) {
        this.victories = victories;
    }
}

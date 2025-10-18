package com.morningvalue.application.dto;

public class SpeciesDTO {
    private Long id;
    private String name;
    private Integer powerLevel;
    private String specialPower;

    public SpeciesDTO() {
    }

    public SpeciesDTO(Long id, String name, Integer powerLevel, String specialPower) {
        this.id = id;
        this.name = name;
        this.powerLevel = powerLevel;
        this.specialPower = specialPower;
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
}

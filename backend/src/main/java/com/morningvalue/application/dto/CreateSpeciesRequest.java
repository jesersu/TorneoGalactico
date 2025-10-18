package com.morningvalue.application.dto;

public class CreateSpeciesRequest {
    private String name;
    private Integer powerLevel;
    private String specialPower;

    public CreateSpeciesRequest() {
    }

    public CreateSpeciesRequest(String name, Integer powerLevel, String specialPower) {
        this.name = name;
        this.powerLevel = powerLevel;
        this.specialPower = specialPower;
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

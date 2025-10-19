package com.morningvalue.application.dto;

public class CreateFightRequest {
    private Long species1Id;
    private Long species2Id;

    public CreateFightRequest() {
    }

    public CreateFightRequest(Long species1Id, Long species2Id) {
        this.species1Id = species1Id;
        this.species2Id = species2Id;
    }

    public Long getSpecies1Id() {
        return species1Id;
    }

    public void setSpecies1Id(Long species1Id) {
        this.species1Id = species1Id;
    }

    public Long getSpecies2Id() {
        return species2Id;
    }

    public void setSpecies2Id(Long species2Id) {
        this.species2Id = species2Id;
    }
}

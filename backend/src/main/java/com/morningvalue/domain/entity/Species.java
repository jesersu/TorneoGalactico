package com.morningvalue.domain.entity;

import java.util.Objects;

public class Species {
    private Long id;
    private String name;
    private Integer powerLevel;
    private String specialPower;

    public Species() {
    }

    public Species(Long id, String name, Integer powerLevel, String specialPower) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Species species = (Species) o;
        return Objects.equals(id, species.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Species{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", powerLevel=" + powerLevel +
                ", specialPower='" + specialPower + '\'' +
                '}';
    }
}

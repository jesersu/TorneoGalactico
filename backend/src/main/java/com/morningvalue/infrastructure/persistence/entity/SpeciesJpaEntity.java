package com.morningvalue.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "species")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpeciesJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, name = "power_level")
    private Integer powerLevel;

    @Column(nullable = false, name = "special_power", length = 500)
    private String specialPower;
}

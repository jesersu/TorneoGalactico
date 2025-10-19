package com.morningvalue.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "fights")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FightJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "species1_id", nullable = false)
    private SpeciesJpaEntity species1;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "species2_id", nullable = false)
    private SpeciesJpaEntity species2;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "winner_id", nullable = false)
    private SpeciesJpaEntity winner;

    @Column(nullable = false, name = "fight_date")
    private LocalDateTime fightDate;

    @Column(nullable = false, name = "battle_description", length = 1000)
    private String battleDescription;
}

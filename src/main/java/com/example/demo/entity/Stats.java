package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Stats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private byte strength;
    private byte dexterity;
    private byte wisdom;
    private byte intelligence;
    private byte charisma;

    @OneToOne(mappedBy = "stats")
    private Player player;
}

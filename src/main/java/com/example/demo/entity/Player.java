package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    @ManyToOne
    @JoinColumn(name = "guild_id")
    Guild guild;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "player")
    Gear gear;

    @ManyToOne
    @JoinColumn(name = "stats_id")
    Stats stats;

}

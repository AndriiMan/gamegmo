package com.example.demo.entity;

import com.example.demo.entity.enums.Ranks;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Guild {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "guild")
    Set<Player> members;

    String location;

    @Enumerated(value = EnumType.STRING)
    Ranks ranks;

}

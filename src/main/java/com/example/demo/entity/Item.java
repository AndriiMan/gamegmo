package com.example.demo.entity;

import com.example.demo.entity.enums.ItemType;
import com.example.demo.entity.enums.Rarity;
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
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "gear_id")
    Gear gear;

    @Enumerated(value = EnumType.STRING)
    ItemType type;

    @Enumerated(value = EnumType.STRING)
    Rarity rarity;

//ItemStats ItemStats
}

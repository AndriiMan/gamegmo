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
    private Long id;

    @ManyToOne
    @JoinColumn(name = "gear_id")
    private Gear gear;

    @Enumerated(value = EnumType.STRING)
    private ItemType type;

    @Enumerated(value = EnumType.STRING)
    private Rarity rarity;
}
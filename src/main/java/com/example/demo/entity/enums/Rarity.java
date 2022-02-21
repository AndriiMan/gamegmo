package com.example.demo.entity.enums;

import java.util.Random;

public enum Rarity {
    COMMON,
    UNCOMMON,
    RARE,
    LEGENDARY,
    MYTHICAL,
    IMMORTAL,
    ANCIENT;

    public static Rarity getRandomRarity() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}

package com.example.demo.entity.enums;

import java.util.Random;

public enum Ranks {
    NOVICE,
    INITIATE,
    APPRENTICE,
    JUNIOR,
    MASTER,
    SENIOR,
    ELDER;

    public static Ranks getRandomRank() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}

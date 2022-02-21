package com.example.demo.entity.enums;

import java.util.Random;

public enum ItemType {
    HEAD,
    TORSO,
    LEGS,
    SHOULDERS,
    ARMS,
    SHIELD,
    MAGIC_ITEM;

    public static ItemType getRandomItemType() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}

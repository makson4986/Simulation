package org.makson.entityTypes;

import java.util.Random;

public enum PredatorType {
    LEOPARD,
    CROCODILE,
    TIGER;

    public static PredatorType getRandomType() {
        return PredatorType.values()[new Random().nextInt(PredatorType.values().length)];
    }

    public String getEmoji() {
        return switch (this) {
            case LEOPARD -> "\uD83D\uDC06";
            case CROCODILE -> "\uD83D\uDC0A";
            case TIGER -> "\uD83D\uDC05";
        };
    }
}
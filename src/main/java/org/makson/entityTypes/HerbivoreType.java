package org.makson.entityTypes;

import java.util.Random;

public enum HerbivoreType {
    LLAMA,
    GIRAFFE,
    ELEPHANT,
    HIPPOPOTAMUS;

    public static HerbivoreType getRandomType() {
        return HerbivoreType.values()[new Random().nextInt(HerbivoreType.values().length)];
    }

    public String getEmoji() {
        return switch (this) {
            case LLAMA -> "\uD83E\uDD99";
            case GIRAFFE -> "\uD83E\uDD92";
            case ELEPHANT -> "\uD83D\uDC18";
            case HIPPOPOTAMUS -> "\uD83E\uDD9B";
        };
    }
}

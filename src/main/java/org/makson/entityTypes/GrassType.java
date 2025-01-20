package org.makson.entityTypes;

import java.util.Random;

public enum GrassType {
    EAR_OF_RICE,
    SHAMROCK,
    SEEDLING,
    HERB;

    public static GrassType getRandomType() {
        return GrassType.values()[new Random().nextInt(GrassType.values().length)];
    }

    public String getEmoji() {
        return switch (this) {
            case EAR_OF_RICE -> "\uD83C\uDF3E";
            case SHAMROCK -> "\uD83C\uDF40";
            case SEEDLING -> "\uD83C\uDF31";
            case HERB -> "\uD83C\uDF3F";
        };
    }
}

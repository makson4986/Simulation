package org.makson.entity.food;

public enum GrassType {
    EAR_FOR_RICE,
    HERB,
    SEEDLING,
    SHAMROCK;

    public String getEmoji() {
        return switch (this) {
            case EAR_FOR_RICE -> "\uD83C\uDF3E";
            case HERB -> "\uD83C\uDF3F";
            case SEEDLING -> "\uD83C\uDF40";
            case SHAMROCK -> "\uD83C\uDF31";
        };
    }
}

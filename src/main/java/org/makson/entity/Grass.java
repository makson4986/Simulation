package org.makson.entity;

import org.makson.Coordinates;
import org.makson.entityTypes.GrassType;

public class Grass extends Entity {
    private final GrassType type;
    private boolean isEaten;

    public Grass() {
        type = GrassType.getRandomType();
    }

    public boolean isEaten() {
        return isEaten;
    }

    public void eaten(boolean eaten) {
        isEaten = eaten;
    }

    @Override
    public String getEmoji() {
        return type.getEmoji();
    }
}

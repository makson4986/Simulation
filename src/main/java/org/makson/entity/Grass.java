package org.makson.entity;

import org.makson.Coordinates;
import org.makson.entityTypes.GrassType;

public class Grass extends Entity {
    private final GrassType type;

    public Grass() {
        type = GrassType.getRandomType();
    }

    @Override
    public String getEmoji() {
        return type.getEmoji();
    }
}

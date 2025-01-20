package org.makson.entity;

import org.makson.Coordinates;
import org.makson.entityTypes.HerbivoreType;

public class Herbivore extends Creature {
    private final HerbivoreType type;

    public Herbivore(int speed, int health) {
        super(speed, health);
        type = HerbivoreType.getRandomType();
    }

    @Override
    public void makeMove() {

    }

    @Override
    public String getEmoji() {
        return type.getEmoji();
    }
}

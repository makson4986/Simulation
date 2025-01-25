package org.makson.entity;

import org.makson.entityTypes.HerbivoreType;

import java.util.List;

public class Herbivore extends Creature {
    private final HerbivoreType type;

    public Herbivore(int speed, int health) {
        super(speed, health);
        targetEntity = List.of(Grass.class);
        type = HerbivoreType.getRandomType();
    }

    @Override
    public String getEmoji() {
        return type.getEmoji();
    }
}

package org.makson.entity;

import org.makson.entityTypes.HerbivoreType;
import org.makson.field.Field;

import java.util.List;

public class Herbivore extends Creature {
    private final HerbivoreType type;

    public Herbivore(int speed, int health) {
        super(speed, health);
        targetEntities = List.of(Grass.class);
        type = HerbivoreType.getRandomType();
    }

    private void eatGrass(Entity target) {
        //target is always a Grass object
        Grass grass = (Grass) target;
        grass.eaten(true);
    }

    public HerbivoreType getType() {
        return type;
    }

    @Override
    public void makeMove(Field field) {
        super.makeMove(field);

        if (pathToTarget.size() == 1) {
            eatGrass(currentTarget);
        }
    }

    @Override
    public String getEmoji() {
        return type.getEmoji();
    }
}

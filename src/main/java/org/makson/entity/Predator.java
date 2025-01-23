package org.makson.entity;

import org.makson.Coordinates;
import org.makson.Field;
import org.makson.entityTypes.PredatorType;

import java.util.List;

public class Predator extends Creature {
    private final int attackRange;
    private final int damage;
    private final PredatorType type;

    public Predator(int speed, int health, int damage, int attackRange) {
        super(speed, health);
        this.damage = damage;
        this.attackRange = attackRange;
        targetEntity = List.of(Herbivore.class);
        type = PredatorType.getRandomType();
    }

//    @Override
//    public void makeMove(Field field) {
//
//    }

    @Override
    public String getEmoji() {
        return type.getEmoji();
    }
}

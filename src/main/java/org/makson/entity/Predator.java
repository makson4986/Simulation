package org.makson.entity;

import org.makson.Coordinates;
import org.makson.entityTypes.PredatorType;

public class Predator extends Creature {
    private final int attackRange;
    private final int damage;
    private final PredatorType type;

    public Predator(int speed, int health, int damage, int attackRange) {
        super(speed, health);
        this.damage = damage;
        this.attackRange = attackRange;
        type = PredatorType.getRandomType();
    }

    @Override
    public void makeMove() {

    }

    @Override
    public String getEmoji() {
        return type.getEmoji();
    }
}

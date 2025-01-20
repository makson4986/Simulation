package org.makson.entity;

import org.makson.Coordinates;

public abstract class Creature extends Entity {
    protected int health;
    protected final int speed;

    public Creature(int speed, int health) {
        this.speed = speed;
        this.health = health;
    }

    public abstract void makeMove();
}

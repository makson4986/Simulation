package org.makson.entity.creature;

import org.makson.entity.Entity;

public abstract class Creature extends Entity {
    protected int health;
    protected int speed;

    public abstract void makeMove();
}

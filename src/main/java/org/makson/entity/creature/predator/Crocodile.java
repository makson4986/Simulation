package org.makson.entity.creature.predator;

public class Crocodile extends Predator {
    public Crocodile() {
        health = 15;
        speed = 1;
        damage = 3;
        attackRange = 1;
    }

    @Override
    public String getEmoji() {
        return "\uD83D\uDC0A";
    }
}

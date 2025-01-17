package org.makson.entity.creature.predator;

public class Tiger extends Predator {
    public Tiger() {
        health = 20;
        speed = 2;
        damage = 6;
        attackRange = 2;
    }

    @Override
    public String getEmoji() {
        return "\uD83D\uDC05";
    }
}

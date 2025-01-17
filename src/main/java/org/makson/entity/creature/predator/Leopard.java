package org.makson.entity.creature.predator;

public class Leopard extends Predator {
    public Leopard() {
        health = 12;
        speed = 3;
        damage = 5;
        attackRange = 2;
    }

    @Override
    public String getEmoji() {
        return "\uD83D\uDC06";
    }
}

package org.makson.entity;

import org.makson.entityTypes.PredatorType;
import org.makson.field.Field;
import org.makson.simulation.SimulationInformation;

import java.util.List;

public class Predator extends Creature {
    private final int attackRange;
    private final int damage;
    private final PredatorType type;

    public Predator(int speed, int health, int damage, int attackRange) {
        super(speed, health);
        this.damage = damage;
        this.attackRange = attackRange;
        this.targetEntities = List.of(Herbivore.class);
        this.type = PredatorType.getRandomType();
    }

    private void attackTarget(Entity target) {
        //target is always a Herbivore object
        Herbivore herbivore = (Herbivore) target;
        herbivore.setHealth(herbivore.getHealth() - damage);

        if (herbivore.getHealth() <= 0) {
            SimulationInformation.showInfoKill(this, herbivore);
        } else {
            SimulationInformation.showInfoDamage(this, herbivore);
        }

    }

    public int getDamage() {
        return damage;
    }

    public PredatorType getType() {
        return type;
    }

    @Override
    public void makeMove(Field field) {
        super.makeMove(field);

        if (pathToTarget.size() - pathToTarget.indexOf(coordinates) - 1 <= attackRange) {
            attackTarget(currentTarget);
        }
    }

    @Override
    public String getEmoji() {
        return type.getEmoji();
    }
}

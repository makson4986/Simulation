package org.makson.entity;

import org.makson.Coordinates;
import org.makson.cell.CellUtils;
import org.makson.entityTypes.PredatorType;
import org.makson.field.Field;

import java.util.List;

public class Predator extends Creature {
    private final int attackRange;
    private final int damage;
    private final PredatorType type;

    public Predator(int speed, int health, int damage, int attackRange) {
        super(speed, health);
        this.damage = damage;
        this.attackRange = attackRange;
        this.targetEntity = List.of(Herbivore.class);
        this.type = PredatorType.getRandomType();
    }

    private void attackTarget(Entity target) {
        //target is always a Creature object
        Creature herbivore = (Creature) target;
        herbivore.setHealth(herbivore.getHealth() - damage);
    }

    @Override
    public void makeMove(Field field) {
        Entity target = findNearestTarget(field);

        List<Coordinates> pathToTarget = CellUtils.getShortPathBetweenTwoCell(getCoordinates(), target.getCoordinates(), field);
        field.removeEntity(coordinates);

        try {
            coordinates = pathToTarget.get(speed - 1);
        } catch (IndexOutOfBoundsException e) {
            coordinates =  pathToTarget.getLast();
        }

        field.setEntity(this, getCoordinates());

        if (pathToTarget.size() - pathToTarget.indexOf(coordinates) <= attackRange) {
            attackTarget(target);
        }
    }

    @Override
    public String getEmoji() {
        return type.getEmoji();
    }
}

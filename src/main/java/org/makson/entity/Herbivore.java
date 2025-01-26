package org.makson.entity;

import org.makson.Coordinates;
import org.makson.cell.CellUtils;
import org.makson.entityTypes.HerbivoreType;
import org.makson.field.Field;

import java.util.List;

public class Herbivore extends Creature {
    private final HerbivoreType type;

    public Herbivore(int speed, int health) {
        super(speed, health);
        targetEntity = List.of(Grass.class);
        type = HerbivoreType.getRandomType();
    }

    private void eatGrass(Entity target) {
        //target is always a Grass object
        Grass grass = (Grass) target;
        grass.eaten(true);
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

        if (coordinates.equals(pathToTarget.getLast())) {
            eatGrass(target);
        }
    }

    @Override
    public String getEmoji() {
        return type.getEmoji();
    }
}

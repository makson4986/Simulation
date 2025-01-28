package org.makson.entity;

import org.makson.cell.CellUtils;
import org.makson.Coordinates;
import org.makson.field.Field;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public abstract class Creature extends Entity {
    protected int health;
    protected final int speed;
    protected List<Class<? extends Entity>> targetEntities;
    protected Entity currentTarget;
    protected List<Coordinates> pathToTarget;

    public Creature(int speed, int health) {
        this.speed = speed;
        this.health = health;
        pathToTarget = new ArrayList<>();
    }

    public void makeMove(Field field) {
        currentTarget = findNearestTarget(field);
        try {
            pathToTarget = CellUtils.getShortPathBetweenTwoCell(getCoordinates(), currentTarget.getCoordinates(), field);
        } catch (NoSuchElementException e) {
            return;
        }

        field.removeEntity(this);

        if (pathToTarget.size() != 1) {
            try {
                coordinates = pathToTarget.get(speed - 1);
            } catch (IndexOutOfBoundsException e) {
                coordinates =  pathToTarget.getLast();
            }

            if (coordinates.equals(pathToTarget.getLast())) {
                coordinates = pathToTarget.get(pathToTarget.size() - 2);
            }
        }

        field.setEntity(this, getCoordinates());
    }

    protected Entity findNearestTarget(Field field) {
        //                     right,    down,   left,   up
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int layer = 1; layer <= field.getSize(); layer++) {
            int currentX = this.coordinates.x() - layer;
            int currentY = this.coordinates.y() - layer;

            for (int direction = 0; direction < 4; direction++) {

                for (int step = 0; step < 2 * layer; step++) {
                    currentX += directions[direction][0];
                    currentY += directions[direction][1];
                    Coordinates coordinates = new Coordinates(currentX, currentY);
                    Entity entity = field.getEntity(coordinates);

                    if (targetEntities.stream().anyMatch(target -> target.isInstance(entity))) {
                        return entity;
                    }
                }
            }
        }
        return null;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }


}

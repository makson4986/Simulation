package org.makson.entity;

import org.makson.cell.CellUtils;
import org.makson.Coordinates;
import org.makson.field.Field;

import java.util.List;

public abstract class Creature extends Entity {
    protected int health;
    protected final int speed;
    protected List<Class<? extends Entity>> targetEntity;

    public Creature(int speed, int health) {
        this.speed = speed;
        this.health = health;
    }

    public void makeMove(Field field) {
        List<Coordinates> pathToTarget = CellUtils.getShortPathBetweenTwoCell(getCoordinates(), findNearestTarget(field).getCoordinates(), field);
        field.removeEntity(coordinates);

        try {
            coordinates = pathToTarget.get(speed - 1);
        } catch (IndexOutOfBoundsException e) {
            coordinates =  pathToTarget.getLast();
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

                    if (targetEntity.stream().anyMatch(target -> target.isInstance(entity))) {
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

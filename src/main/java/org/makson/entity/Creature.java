package org.makson.entity;

import org.makson.Coordinates;
import org.makson.Field;

import java.util.List;

public abstract class Creature extends Entity {
    protected int health;
    protected final int speed;
    protected List<Class<? extends Entity>> targetEntity;

    public Creature(int speed, int health) {
        this.speed = speed;
        this.health = health;
    }

    protected List<Coordinates> findPathToTarget(Field field) {
        return null;
    }

    protected Entity findNearestTarget(Field field) {
        //                     right,    down,   left,   up
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0; //right

        for (int layer = 1; layer <= field.getSize() / 2; layer++) {
            int currentX = this.coordinates.x() - layer;
            int currentY = this.coordinates.y() - layer;

            for (int direction = 0; direction < 4; direction++) {
                directionIndex = direction;

                for (int step = 0; step < 2 * layer; step++) {
                    currentX += directions[directionIndex][0];
                    currentY += directions[directionIndex][1];
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

    public void makeMove(Field field) {
        List<Coordinates> pathToTarget = findPathToTarget(field);
        this.coordinates = pathToTarget.get(speed - 1);
    }

    private int straightLineDistance(Coordinates from, Coordinates to) {
        return Math.abs((from.x()) - to.x()) + Math.abs((from.y()) - to.y());
    }

}

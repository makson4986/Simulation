package org.makson.entity;

import org.makson.Coordinates;

public abstract class Entity {
    protected Coordinates coordinates;

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public abstract String getEmoji();
}

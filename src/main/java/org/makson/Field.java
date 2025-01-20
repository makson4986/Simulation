package org.makson;

import org.makson.entity.Entity;

import java.util.HashMap;
import java.util.Map;

public class Field {
    private Map<Coordinates, Entity> field = new HashMap<>();
    private final int size;
//    private final EntityGenerator generator;

    public Field() {
        this(10, 5, 5, 5, 5);
    }

    public Field(int size, int decorativeBlockPercent, int foodPercent, int herbivorePercent, int predatorPercent) {
        this.size = size;
//        generator = new EntityGenerator(size, decorativeBlockPercent, foodPercent, herbivorePercent, predatorPercent);
//        setEntity(size, field);
    }

    public Entity getEntity(Coordinates coordinates) {
        return field.get(coordinates);
    }

    public int getQuantityEntities(Class<? extends Entity> entityType) {
        return (int) field.values().stream().filter(entityType::isInstance).count();
    }

    private void setEntity(Entity entity, Coordinates coordinates) {

    }

    public int getSize() {
        return size;
    }
}

package org.makson.entity;

import java.util.List;

public class EntityGenerator {
    private final int PERCENT_OF_DECORATIVE_OBJECTS;
    private final int PERCENT_OF_FOOD;
    private final int PERCENT_OF_HERBIVORE;
    private final int PERCENT_OF_PREDATOR;

    public EntityGenerator(int sizeField, int PERCENT_OF_DECORATIVE_OBJECTS,
                           int PERCENT_OF_FOOD, int PERCENT_OF_HERBIVORE,
                           int PERCENT_OF_PREDATOR) {

        if (isCorrectPercent(PERCENT_OF_FOOD, PERCENT_OF_HERBIVORE, PERCENT_OF_DECORATIVE_OBJECTS, PERCENT_OF_PREDATOR)) {
            this.PERCENT_OF_DECORATIVE_OBJECTS = PERCENT_OF_DECORATIVE_OBJECTS;
            this.PERCENT_OF_FOOD = PERCENT_OF_FOOD;
            this.PERCENT_OF_HERBIVORE = PERCENT_OF_HERBIVORE;
            this.PERCENT_OF_PREDATOR = PERCENT_OF_PREDATOR;
        }
    }

    public List<Entity> generateEntity() {
        return null;
    }

    private boolean isCorrectPercent(int PERCENT_OF_DECORATIVE_OBJECTS, int PERCENT_OF_FOOD,
                                     int PERCENT_OF_HERBIVORE, int PERCENT_OF_PREDATOR) {

        return PERCENT_OF_FOOD + PERCENT_OF_HERBIVORE + PERCENT_OF_DECORATIVE_OBJECTS + PERCENT_OF_PREDATOR <= 100;
    }
}

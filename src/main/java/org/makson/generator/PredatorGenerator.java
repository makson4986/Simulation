package org.makson.generator;

import org.makson.field.Field;
import org.makson.entity.Entity;
import org.makson.entity.Predator;

import java.util.Random;

public class PredatorGenerator extends Generator {
    public PredatorGenerator(Field field, int density) {
        super(field, density);
    }

    @Override
    protected Entity generateEntity() {
        int speed = new Random().nextInt(1, 4);
        int health = new Random().nextInt(10, 16);
        int damage = new Random().nextInt(1, 5);
        int attackRange = new Random().nextInt(1, 2);

        return new Predator(speed, health, damage, attackRange);
    }
}

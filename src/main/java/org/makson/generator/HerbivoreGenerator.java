package org.makson.generator;

import org.makson.Field;
import org.makson.entity.Entity;
import org.makson.entity.Herbivore;

import java.util.Random;

public class HerbivoreGenerator extends Generator {
    public HerbivoreGenerator(Field field, int density) {
        super(field, density);
    }

    @Override
    protected Entity generateEntity() {
        int speed = new Random().nextInt(1, 6);
        int health = new Random().nextInt(15, 46);

        return new Herbivore(speed, health);
    }
}

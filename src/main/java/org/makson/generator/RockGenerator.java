package org.makson.generator;

import org.makson.Field;
import org.makson.entity.Entity;
import org.makson.entity.Rock;

public class RockGenerator extends Generator {
    public RockGenerator(Field field, int density) {
        super(field, density);
    }

    @Override
    protected Entity generateEntity() {
        return new Rock();
    }
}

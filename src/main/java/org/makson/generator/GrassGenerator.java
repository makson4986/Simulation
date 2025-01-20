package org.makson.generator;

import org.makson.Field;
import org.makson.entity.Entity;
import org.makson.entity.Grass;

public class GrassGenerator extends Generator {
    public GrassGenerator(Field field, int density) {
        super(field, density);
    }

    @Override
    protected Entity generateEntity() {
        return new Grass();
    }
}

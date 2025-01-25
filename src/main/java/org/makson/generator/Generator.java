package org.makson.generator;

import org.makson.field.Field;
import org.makson.entity.Entity;

import java.util.ArrayList;
import java.util.List;

public abstract class Generator {
    protected int sizeField;
    protected int density;

    public Generator(Field field, int density) {
        this.sizeField = field.getSize();
        this.density = density;
    }

    public List<Entity> generate() {
        List<Entity> generatedEntity = new ArrayList<>();
        int quantityEntity = sizeField * sizeField * density / 100;

        for (int i = 0; i < quantityEntity; i++) {
            generatedEntity.add(generateEntity());
        }

        return generatedEntity;
    }

    protected abstract Entity generateEntity();
}

package org.makson.generator;

import org.makson.field.Field;
import org.makson.entity.Entity;
import org.makson.entity.Tree;

public class TreeGenerator extends Generator {
    public TreeGenerator(Field field, int density) {
        super(field, density);
    }

    @Override
    protected Entity generateEntity() {
        return new Tree();
    }
}

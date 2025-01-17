package org.makson;

import org.makson.entity.Entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Field {
    private Map<Coordinates, Entity> field;

    public Field(int size) {
        field = generateField(size);
    }

    private HashMap<Coordinates, Entity> generateField(int size) {
        Map<Coordinates, Entity> field = new HashMap<>();

        return null;
    }
}

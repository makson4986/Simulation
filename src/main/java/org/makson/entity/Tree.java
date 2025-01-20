package org.makson.entity;

import org.makson.entityTypes.TreeType;

public class Tree extends Entity {
    private final TreeType type;

    public Tree() {
        type = TreeType.getRandomType();
    }

    @Override
    public String getEmoji() {
        return type.getEmoji();
    }
}

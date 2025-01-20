package org.makson.entityTypes;

import org.makson.entity.Tree;

import java.util.Random;

public enum TreeType {
    SPRUCE,
    PALM,
    DECIDUOUS_TREE;

    public static TreeType getRandomType() {
        return TreeType.values()[new Random().nextInt(TreeType.values().length)];
    }

    public String getEmoji() {
        return switch (this) {
            case SPRUCE -> "\uD83C\uDF32";
            case PALM -> "\uD83C\uDF34";
            case DECIDUOUS_TREE -> "\uD83C\uDF33";
        };
    }
}

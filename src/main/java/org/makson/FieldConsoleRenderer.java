package org.makson;

import org.makson.entity.Entity;

public class FieldConsoleRenderer {
    private final String ANSI_EMPTY_SQUARE = "\u2004\u2004\u2000\u2000\u2004";
    private final String ANSI_THIRD_SPACE = "\u2004";

    public void render(Field field) {
        for (int i = 0; i < field.getSize(); i++) {
            for (int j = 0; j < field.getSize(); j++) {
                if (field.getEntity(new Coordinates(i, j)) != null) {
                    System.out.print(getSpriteWithEntity(field.getEntity(new Coordinates(i, j))));
                } else {
                    System.out.print(getEmptySprite());
                }
            }
            System.out.println();
        }
    }

    private String getSpriteWithEntity(Entity entity) {
        return ANSI_THIRD_SPACE + entity.getEmoji() + ANSI_THIRD_SPACE;
    }

    private String getEmptySprite() {
        return ANSI_EMPTY_SQUARE;
    }
}

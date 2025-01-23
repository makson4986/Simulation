package org.makson.actions;

import org.makson.Field;
import org.makson.entity.Creature;

import java.util.List;

public class MovementEntityAction extends Action {
    @Override
    public void execute(Field field) {
        List<Creature> allCreature = field.getAllCreature();

        for (Creature entity : allCreature) {
            entity.makeMove(field);
        }
    }
}

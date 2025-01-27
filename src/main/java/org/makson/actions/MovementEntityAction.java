package org.makson.actions;

import org.makson.entity.Creature;
import org.makson.field.Field;

import java.util.List;

public class MovementEntityAction extends Action {
    @Override
    public void execute(Field field) {
        List<Creature> allCreature =  field.getAllEntitiesGivenType(Creature.class).stream()
                .map(entity -> (Creature) entity)
                .toList();

        for (Creature entity : allCreature) {
            entity.makeMove(field);
        }
    }
}

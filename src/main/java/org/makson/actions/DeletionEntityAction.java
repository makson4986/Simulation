package org.makson.actions;

import org.makson.entity.Grass;
import org.makson.entity.Herbivore;
import org.makson.field.Field;

import java.util.List;

public class DeletionEntityAction extends Action {
    @Override
    public void execute(Field field) {
        removeDeadHerbivore(field);
        removeEatenGrass(field);
    }

    private void removeDeadHerbivore(Field field) {
        List<Herbivore> entities = field.getAllEntitiesGivenType(Herbivore.class).stream()
                .map(entity -> (Herbivore) entity)
                .filter(entity -> entity.getHealth() <= 0)
                .toList();

        for (Herbivore entity : entities) {
            field.removeEntity(entity);
        }
    }

    private void removeEatenGrass(Field field) {
        List<Grass> grasses = field.getAllEntitiesGivenType(Grass.class).stream()
                .map(grass -> (Grass) grass)
                .filter(Grass::isEaten)
                .toList();

        for (Grass grass : grasses) {
            field.removeEntity(grass);
        }
    }
}

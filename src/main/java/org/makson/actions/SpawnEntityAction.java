package org.makson.actions;

import org.makson.Coordinates;
import org.makson.field.Field;
import org.makson.entity.Entity;
import org.makson.generator.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SpawnEntityAction extends Action {
    private final List<Generator> generators = new ArrayList<>();

    private void setGenerators(List<Generator> generators, Field field) {
        generators.add(new GrassGenerator(field, field.getSettings().getDensityGrass()));
        generators.add(new TreeGenerator(field, field.getSettings().getDensityTree()));
        generators.add(new RockGenerator(field, field.getSettings().getDensityRock()));
        generators.add(new HerbivoreGenerator(field, field.getSettings().getDensityHerbivore()));
        generators.add(new PredatorGenerator(field, field.getSettings().getDensityPredator()));
    }

    @Override
    public void execute(Field field) {
        List<Entity> allEntity = getAllEntity(field);

        int sizeField = field.getSize();

        for (int i = 0; i < allEntity.size(); ) {
            Coordinates coordinates = new Coordinates(new Random().nextInt(sizeField), new Random().nextInt(sizeField));

            if (field.isCoordinateEmpty(coordinates)) {
                allEntity.get(i).setCoordinates(coordinates);
                field.setEntity(allEntity.get(i++), coordinates);
            }
        }
    }

    private List<Entity> getAllEntity(Field field) {
        setGenerators(generators, field);

        List<Entity> result = new ArrayList<>();

        for (Generator generator : generators) {
            result.addAll(generator.generate());
        }

        return result;
    }
}

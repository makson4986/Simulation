package org.makson.actions;

import org.makson.Field;
import org.makson.InputData;
import org.makson.entity.Entity;
import org.makson.generator.*;

import java.util.ArrayList;
import java.util.List;

public class SpawnEntityAction extends Action {
    private final List<Generator> generators = new ArrayList<>();

    private void setGenerators(List<Generator> generators, Field field) {
        generators.add(new GrassGenerator(field, InputData.inputSettingsSimulation("Введите количество травы в %: ")));
        generators.add(new TreeGenerator(field, InputData.inputSettingsSimulation("Введите количество деревьев в %: ")));
        generators.add(new RockGenerator(field, InputData.inputSettingsSimulation("Введите количество камней в %: ")));
        generators.add(new HerbivoreGenerator(field, InputData.inputSettingsSimulation("Введите количество еды для травоядных в %: ")));
        generators.add(new PredatorGenerator(field, InputData.inputSettingsSimulation("Введите количество хищников в %: ")));
    }

    @Override
    public void execute(Field field) {
        setGenerators(generators, field);

        List<Entity> allEntity = new ArrayList<>();

        for (Generator generator : generators) {
            allEntity.addAll(generator.generate());
        }

        //TODO расставить их на карту
    }
}

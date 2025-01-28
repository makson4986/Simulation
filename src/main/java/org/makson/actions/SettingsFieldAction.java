package org.makson.actions;

import org.makson.Validator;
import org.makson.field.Field;
import org.makson.simulation.InputData;

public class SettingsFieldAction extends Action {
    private int size;
    private int densityGrass;
    private int densityRock;
    private int densityTree;
    private int densityPredator;
    private int densityHerbivore;

    public SettingsFieldAction() {
        if (InputData.inputDefaultOrCustomSimulation() == 1) {
            setDefaultSettings();
        } else {
            setCustomSettings();
        }
    }

    private void setDefaultSettings() {
        size = 10;
        densityGrass = 6;
        densityRock = 3;
        densityTree = 3;
        densityPredator = 6;
        densityHerbivore = 6;
    }

    private void setCustomSettings() {
        while (true) {
            size = InputData.inputSettingsSimulation("Введите размер поля: ");
            densityGrass = InputData.inputSettingsSimulation("Введите количество травы в %: ");
            densityRock = InputData.inputSettingsSimulation("Введите количество камней в %: ");
            densityTree = InputData.inputSettingsSimulation("Введите количество деревьев в %: ");
            densityHerbivore = InputData.inputSettingsSimulation("Введите количество травоядных в %: ");
            densityPredator = InputData.inputSettingsSimulation("Введите количество хищников в %: ");

            if (!Validator.isCorrectTotalPercentage(densityGrass, densityRock, densityTree, densityHerbivore, densityPredator)) {
                System.out.println("Общее количество процентов не может быть больше 100!\n");
            } else {
                break;
            }
        }
    }

    public int getSize() {
        return size;
    }

    public int getDensityGrass() {
        return densityGrass;
    }

    public int getDensityRock() {
        return densityRock;
    }

    public int getDensityTree() {
        return densityTree;
    }

    public int getDensityPredator() {
        return densityPredator;
    }

    public int getDensityHerbivore() {
        return densityHerbivore;
    }

    @Override
    public void execute(Field field) {
        field.setSettings(this);
    }
}

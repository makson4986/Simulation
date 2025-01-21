package org.makson.actions;

import org.makson.Field;
import org.makson.Validator;

import java.util.Scanner;

public class SettingsFieldAction extends Action {
    private int size;
    private int densityGrass;
    private int densityRock;
    private int densityTree;
    private int densityPredator;
    private int densityHerbivore;

    public SettingsFieldAction() {
        if (inputDefaultOrCustomizeSimulation() == 1) {
            setDefaultSettings();
        } else {
            setCustomizeSettings();
        }
    }

    private void setDefaultSettings() {
        size = 10;
        densityGrass = 5;
        densityRock = 5;
        densityTree = 5;
        densityPredator = 5;
        densityHerbivore = 5;

        //TODO настроить адекватно значения
    }

    private void setCustomizeSettings() {
        while (true) {
            size = inputSettingsSimulation("Введите размер поля: ");
            densityGrass = inputSettingsSimulation("Введите количество травы в %: ");
            densityRock = inputSettingsSimulation("Введите количество камней в %: ");
            densityTree = inputSettingsSimulation("Введите количество деревьев в %: ");
            densityHerbivore = inputSettingsSimulation("Введите количество травоядных в %: ");
            densityPredator = inputSettingsSimulation("Введите количество хищников в %: ");

            if (!Validator.isCorrectTotalPercentage(densityGrass, densityRock, densityTree, densityHerbivore, densityPredator)) {
                System.out.println("Общее количество процентов не может быть больше 100!\n");
            }
        }
    }

    @Override
    public void execute(Field field) {
        field.setSettings(this);
    }

    private int inputSettingsSimulation(String outputText) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print(outputText);
            String line = scanner.nextLine();

            int intLine = Validator.tryParseToInteger(line);
            if (intLine != -1) {
                return intLine;
            }

            System.out.println("Неверное значение!\n");
        }
    }

    private int inputDefaultOrCustomizeSimulation() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("""
                    Хотите настроить параметры игры?
                    1. Оставить по умолчанию
                    2. Настроить""");

            String line = scanner.nextLine();

            if (Validator.isCorrectChosenAnswer(line, 2)) {
                return Integer.parseInt(line);
            }

            System.out.println("Неверный вариант ответа!\n");
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
}

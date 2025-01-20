package org.makson;

public class Simulation {
    Field field;
    FieldConsoleRenderer renderer;

    public Simulation() {
        executeActionsBeforeStarting();
        renderer = new FieldConsoleRenderer();
    }

    public void executeActionsBeforeStarting() {
        if (InputData.inputDefaultOrCustomizeSimulation() == 1) {
            field = new Field();
        } else {
            while (true) {
                int sizeField = InputData.inputSettingsSimulation("Введите размер поля симуляции (поле в виде квадрата): ");
                int predatorPercent = InputData.inputSettingsSimulation("Введите количество хищников в %: ");
                int herbivorePercent = InputData.inputSettingsSimulation("Введите количество травоядных в %: ");
                int foodPercent = InputData.inputSettingsSimulation("Введите количество еды для травоядных в %: ");
                int decorativeBlockPercent = InputData.inputSettingsSimulation("Введите количество декоративных блоков в %: ");

                if (Validator.isCorrectTotalPercentage(decorativeBlockPercent, foodPercent, herbivorePercent, predatorPercent)) {
                    field = new Field(sizeField, decorativeBlockPercent, foodPercent, herbivorePercent, predatorPercent);
                    return;
                }

                System.out.println("Общее количество процентов не должно превышать 100!\n");
            }
        }
    }

    public void nextTurn() {

    }

    public void startSimulation() {
        renderer.render(field);
        SimulationInformation.showInfo(field);
    }

    public void pauseSimulation() {

    }
}

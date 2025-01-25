package org.makson.simulation;

import org.makson.actions.Action;
import org.makson.actions.MovementEntityAction;
import org.makson.actions.SpawnEntityAction;
import org.makson.actions.SettingsFieldAction;
import org.makson.field.Field;
import org.makson.field.FieldConsoleRenderer;

import java.util.List;

public class Simulation {
    Field field;
    FieldConsoleRenderer renderer;
    List<Action> initActions = List.of(new SettingsFieldAction(), new SpawnEntityAction());
    List<Action> turnActions = List.of(new MovementEntityAction());

    public Simulation(Field field) {
        this.field = field;
        renderer = new FieldConsoleRenderer();
    }

    public void nextTurn() {

    }

    public void startSimulation() {
        renderer.render(field);
        SimulationInformation.showInfo(field);
        executeTurnAction();
        renderer.render(field);
    }

    public void pauseSimulation() {

    }

    public void executeInitialActions() {
        for (Action initAction : initActions) {
            initAction.execute(field);
        }
    }

    private void executeTurnAction() {
        for (Action turnAction : turnActions) {
            turnAction.execute(field);
        }
    }
}

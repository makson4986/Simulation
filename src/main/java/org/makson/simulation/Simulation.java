package org.makson.simulation;

import org.makson.actions.*;
import org.makson.endings.CheckEndSimulation;
import org.makson.endings.HerbivoreVictory;
import org.makson.endings.PredatorVictory;
import org.makson.field.Field;
import org.makson.field.FieldConsoleRenderer;

import java.util.List;

public class Simulation {
    Field field;
    FieldConsoleRenderer renderer;
    SimulationState state = SimulationState.ONGOING;
    List<Action> initActions = List.of(new SettingsFieldAction(), new SpawnEntityAction());
    List<Action> turnActions = List.of(new MovementEntityAction(), new DeletionEntityAction());
    List<CheckEndSimulation> endingsSimulation =List.of(new PredatorVictory(), new HerbivoreVictory());

    public Simulation(Field field) {
        this.field = field;
        renderer = new FieldConsoleRenderer();
    }

    public void nextTurn() {

    }

    public void startSimulation() {
        while (state == SimulationState.ONGOING) {
            renderer.render(field);
            SimulationInformation.showInfoSimulation(field);
            executeTurnAction();
            checkEndGame();
        }

        renderer.render(field);
        SimulationInformation.showWinner(state);
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

    private void checkEndGame() {
        for (CheckEndSimulation ending : endingsSimulation) {
            state = ending.checkEnd(field);

            if (state != SimulationState.ONGOING) return;
        }
    }
}

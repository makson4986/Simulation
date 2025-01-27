package org.makson.endings;

import org.makson.entity.Herbivore;
import org.makson.field.Field;
import org.makson.simulation.SimulationState;

public class PredatorVictory extends CheckEndSimulation {
    @Override
    public SimulationState checkEnd(Field field) {
        if (field.getAllEntitiesGivenType(Herbivore.class).isEmpty()) {
            return SimulationState.WIN_PREDATOR;
        }

        return SimulationState.ONGOING;
    }
}

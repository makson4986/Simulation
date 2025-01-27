package org.makson.endings;

import org.makson.entity.Grass;
import org.makson.entity.Herbivore;
import org.makson.field.Field;
import org.makson.simulation.SimulationState;

public class HerbivoreVictory extends CheckEndSimulation {
    @Override
    public SimulationState checkEnd(Field field) {
        if (field.getAllEntitiesGivenType(Grass.class).isEmpty() && !field.getAllEntitiesGivenType(Herbivore.class).isEmpty()) {
            return SimulationState.WIN_HERBIVORE;
        }

        return SimulationState.ONGOING;
    }
}

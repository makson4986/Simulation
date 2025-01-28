package org.makson.endings;

import org.makson.entity.Creature;
import org.makson.field.Field;
import org.makson.simulation.SimulationState;

public class Draw extends CheckEndSimulation {
    @Override
    public SimulationState checkEnd(Field field) {
        for (Creature creature : field.getAllEntitiesGivenType(Creature.class).stream()
                .map(entity -> (Creature) entity)
                .toList()) {

            if (!creature.getPathToTarget().isEmpty()) {
                return SimulationState.ONGOING;
            }
        }

        return SimulationState.DRAW;
    }
}

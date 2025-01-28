package org.makson.simulation;

import org.makson.entity.Grass;
import org.makson.entity.Herbivore;
import org.makson.entity.Predator;
import org.makson.field.Field;

public class SimulationInformation {
    public static void showInfoSimulation(Field field) {
        int quantityPredator = field.getQuantityEntities(Predator.class);
        int quantityHerbivore = field.getQuantityEntities(Herbivore.class);
        int quantityFood = field.getQuantityEntities(Grass.class);

        System.out.printf("""
                Количество хищников: %d
                Количество травоядных: %d
                Количество травы: %d
                
                """,
                quantityPredator, quantityHerbivore, quantityFood);
    }

    public static void showWinner(SimulationState state) {
        if (state == SimulationState.WIN_HERBIVORE) {
            System.out.println("Травоядные выиграли!");
        } else if (state == SimulationState.WIN_PREDATOR) {
            System.out.println("Хищники выиграли!");
        } else {
            System.out.println("Все животные взаперти!");
        }
    }
}

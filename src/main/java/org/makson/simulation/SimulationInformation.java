package org.makson.simulation;

import org.makson.entity.Entity;
import org.makson.entity.Grass;
import org.makson.entity.Herbivore;
import org.makson.entity.Predator;
import org.makson.field.Field;

public class SimulationInformation {
    public static void showInfoSimulation(Field field) {
        int sizeField = field.getSize();
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

    public static void showInfoDamage(Predator entity, Herbivore target) {
        System.out.printf("%s%s наносит %d урона %s%s\n",
                entity.getType().name(),
                entity.getCoordinates(),
                entity.getDamage(),
                target.getType().name(),
                target.getCoordinates());
    }

    public static void showInfoKill(Predator entity, Herbivore target) {
        System.out.printf("%s%s убивает %s%s\n",
                entity.getType().name(),
                entity.getCoordinates(),
                target.getType().name(),
                target.getCoordinates());
    }

    public static void showWinner(SimulationState state) {
        if (state == SimulationState.WIN_HERBIVORE) {
            System.out.println("Травоядные выиграли!");
        } else {
            System.out.println("Хищники выиграли!");
        }
    }
}

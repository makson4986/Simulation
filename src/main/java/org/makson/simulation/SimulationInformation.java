package org.makson.simulation;

import org.makson.entity.Grass;
import org.makson.entity.Herbivore;
import org.makson.entity.Predator;
import org.makson.field.Field;

public class SimulationInformation {
    public static void showInfo(Field field) {
        int sizeField = field.getSize();
        int quantityPredator = field.getQuantityEntities(Predator.class);
        int quantityHerbivore = field.getQuantityEntities(Herbivore.class);
        int quantityFood = field.getQuantityEntities(Grass.class);

        System.out.printf("""
                Размер поля: %dx%d
                Количество хищников: %d
                Количество травоядных: %d
                Количество травы: %d
                """,
                sizeField, sizeField, quantityPredator, quantityHerbivore, quantityFood);
    }
}

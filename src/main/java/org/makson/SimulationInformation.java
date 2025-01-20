package org.makson;

import org.makson.entity.Grass;
import org.makson.entity.Herbivore;
import org.makson.entity.Predator;

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
                Количество еды для травоядных: %d""",
                sizeField, sizeField, quantityPredator, quantityHerbivore, quantityFood);
    }
}

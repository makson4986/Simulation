package org.makson.field;

import org.makson.Coordinates;
import org.makson.actions.SettingsFieldAction;
import org.makson.entity.Creature;
import org.makson.entity.Entity;
import org.makson.entity.Herbivore;
import org.makson.entity.Predator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Field {
    private final Map<Coordinates, Entity> field = new HashMap<>();
    private SettingsFieldAction settings;

    public int getQuantityEntities(Class<? extends Entity> entityType) {
        return (int) field.values().stream().filter(entityType::isInstance).count();
    }

    public boolean isCoordinateEmpty(Coordinates coordinates) {
        return !field.containsKey(coordinates);
    }

    public int getSize() {
        return settings.getSize();
    }

    public void setEntity(Entity entity, Coordinates coordinates) {
        field.put(coordinates, entity);
    }

    public Entity getEntity(Coordinates coordinates) {
        return field.get(coordinates);
    }

    public List<Entity> getAllEntitiesGivenType(Class<? extends Entity> typeEntity) {
        return field.values().stream()
                .filter(typeEntity::isInstance)
                .toList();
    }

    public void removeEntity(Entity entity) {
        field.remove(entity.getCoordinates());
    }

    public void setSettings(SettingsFieldAction settings) {
        this.settings = settings;
    }

    public SettingsFieldAction getSettings() {
        return settings;
    }
}

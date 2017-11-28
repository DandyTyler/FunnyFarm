package com.akos.plants;

/**
 * Создает нужные растения
 */
public class PlantsFactory {
    public static Plant create(String plantName) {
        try {

            Class<Plant> cls = (Class<Plant>) Class.forName("com.akos.plants." + plantName);
            return cls.newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | ClassCastException e) {
            throw new IllegalArgumentException("No such plant: " + plantName, e);
        }

    }
}

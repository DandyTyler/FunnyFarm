package com.akos.plants;

/**
 * Создает нужные растения
 */
public class PlantsFactory {
    public static Plant create(String plantName) {
        if (plantName.equals("Potato"))
            return new Potato();
        if (plantName.equals("Carrot"))
            return new Carrot();
        else throw new IllegalArgumentException(plantName);
    }
}

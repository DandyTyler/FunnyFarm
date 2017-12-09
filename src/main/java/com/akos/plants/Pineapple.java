package com.akos.plants;

import com.akos.Conditions;
import com.akos.exceptions.IllegalConditionException;

/**
 * Ананас. Растет только при влажности больше 55
 */
public class Pineapple extends Fruit {

    private String name = "Pineapple";
    private Conditions conditions;
    private int size = 1;
    private int vitaminC = 30;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getVitaminC() {
        return this.vitaminC;
    }

    @Override
    public boolean isReady() {
        return size > 4;
    }

    @Override
    public void grow() {
        if (conditions.getHumidity() < 55)
            throw new IllegalConditionException("Humidity is too low for pineapple: " + conditions.getHumidity());
        size += 2;
        vitaminC += 16;
    }

    @Override
    public void setConditions(Conditions conditions) {
        this.conditions = conditions;
    }
}

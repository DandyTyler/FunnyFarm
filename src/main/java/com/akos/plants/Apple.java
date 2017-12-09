package com.akos.plants;

import com.akos.Conditions;
import com.akos.Seasons;
import com.akos.exceptions.IllegalConditionException;

/**
 * Яблоко. Яблоки можно собирать, если возраст дерева больше 3 и количество яблок больше 30.
 */
public class Apple extends Fruit {

    private String name = "Apple";
    private Conditions conditions;
    private int age = 1;
    private int appleCount = 0;
    private int vitaminC = 40;

    @Override
    public int getVitaminC() {
        return vitaminC;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isReady() {
        return appleCount > 30 && age > 3;
    }

    @Override
    public void grow() {
        if (conditions.getSeason() == Seasons.WINTER)
            throw new IllegalConditionException("Apple can't grow in this season: " + conditions.getSeason());
        vitaminC += 4;
        age++;
        appleCount += 15;
    }

    @Override
    public void setConditions(Conditions conditions) {
        this.conditions = conditions;
    }
}

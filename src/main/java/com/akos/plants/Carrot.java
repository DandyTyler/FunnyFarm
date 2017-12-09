package com.akos.plants;

import com.akos.Conditions;
import com.akos.exceptions.IllegalConditionException;

/**
 * Морковь. Готова к сборке если размер больше 3
 */
public class Carrot extends Vegetable {

    private String name = "Carrot";
    private int size = 0;
    private Conditions conditions;
    private int vitaminB = 50;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isReady() {
        return size > 3;
    }

    /**
     * Растет только при температуре выше 21 градуса
     */
    @Override
    public void grow() {
        if (conditions.getTemperature() < 21)
            throw new IllegalConditionException("Temperature is too low for carrot: " + conditions.getTemperature());
        size++;
        vitaminB+=11;
    }

    @Override
    public void setConditions(Conditions conditions) {
        this.conditions = conditions;
    }

    @Override
    public int getVitaminB() {
        return vitaminB;
    }
}

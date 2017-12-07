package com.akos.plants;

import com.akos.Conditions;
import com.akos.Seasons;
import com.akos.exceptions.IllegalConditionException;

/**
 * Картофель. Становится готовым к сборке урожая, когда возраст достигает 5.
 */
public class Potato extends Vegetable {
    private String name = "Potato";
    private int age = 0;
    private Conditions conditions;
    private int vitaminB = 70;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isReady() {
        return age > 0;
    }

    /**
     * Картофель не растет зимой
     */
    @Override
    public void grow() {
        if (conditions.getSeason() == Seasons.WINTER)
            throw new IllegalConditionException("This plant can't grow in this season: " + conditions.getSeason());
        age++;
        vitaminB+=2;
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

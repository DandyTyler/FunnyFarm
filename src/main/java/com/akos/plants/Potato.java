package com.akos.plants;

/**
 * Картофель. Становится готовым к сборке урожая, когда возраст достигает 5.
 */
public class Potato implements Plant {
    private String name = "Potato";
    private int age = 0;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isReady() {
        return age > 0;
    }

    @Override
    public void grow() {
        age++;
    }

}

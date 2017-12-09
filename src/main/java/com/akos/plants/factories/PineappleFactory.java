package com.akos.plants.factories;

import com.akos.plants.Pineapple;
import com.akos.plants.Plant;

public class PineappleFactory implements PlantFactory {

    private int cost = 7;

    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public Plant getPlant() {
        return new Pineapple();
    }
}

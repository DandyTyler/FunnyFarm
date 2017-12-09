package com.akos.plants.factories;

import com.akos.plants.Apple;
import com.akos.plants.Plant;

public class AppleFactory implements PlantFactory {

    private int cost = 15;

    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public Plant getPlant() {
        return new Apple();
    }
}

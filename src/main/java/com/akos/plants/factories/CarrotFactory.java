package com.akos.plants.factories;

import com.akos.plants.Carrot;
import com.akos.plants.Plant;

public class CarrotFactory extends PlantFactory{
    private int cost = 1;

    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public Plant getPlant() {
        return new Carrot();
    }
}

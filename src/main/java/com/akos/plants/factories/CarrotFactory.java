package com.akos.plants.factories;

import com.akos.plants.Carrot;
import com.akos.plants.Plant;

public class CarrotFactory implements PlantFactory{
    private int cost = 2;

    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public Plant getPlant() {
        return new Carrot();
    }
}

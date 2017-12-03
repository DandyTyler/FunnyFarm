package com.akos.plants.factories;

import com.akos.plants.Plant;
import com.akos.plants.Potato;
import com.akos.store.Account;

public class PotatoFactory extends PlantFactory {
    private int cost = 5;
    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public Plant getPlant() {
        return new Potato();
    }
}

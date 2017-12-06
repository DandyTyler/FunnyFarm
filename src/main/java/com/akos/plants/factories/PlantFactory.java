package com.akos.plants.factories;

import com.akos.plants.Plant;
import com.akos.store.Account;

public interface PlantFactory {
    public abstract int getCost();
    public abstract Plant getPlant();
}

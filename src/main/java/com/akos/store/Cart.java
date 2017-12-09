package com.akos.store;

import com.akos.plants.Plant;

import java.util.LinkedList;
import java.util.List;

/**
 * Корзина, содержащая в себе купленные растения
 */
public class Cart {

    List<Plant> plantsList = new LinkedList<>();

    /**
     * Добавить растение в корзину
     *
     * @param p добавляемое растение
     */
    public void add(Plant p) {
        plantsList.add(p);
    }

    public List<Plant> getPlantsList() {
        return plantsList;
    }
}

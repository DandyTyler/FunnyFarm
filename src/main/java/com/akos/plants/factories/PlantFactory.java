package com.akos.plants.factories;

import com.akos.plants.Plant;
import com.akos.store.Account;

/**
 * Фабрика, создающая новые растения. Хранит стоимость растения
 */
public interface PlantFactory {

    /**
     * Узнать цену растения
     *
     * @return цена
     */
    int getCost();

    /**
     * Создает новые растения
     *
     * @return новое растение
     */
    Plant getPlant();
}

package com.akos.store;

import java.util.HashMap;
import java.util.Map;

/**
 * Заказ, содержаший список растений и их количество. Количество не может быть меньше 0
 */
public class Order {

    private Map<String, Integer> plants = new HashMap<>();

    /**
     * Добавление в заказ
     *
     * @param name   название растения
     * @param amount количество
     * @return
     */
    public Order add(String name, int amount) {
        Integer i = plants.get(name);
        if ((i != null ? i : 0) + amount < 0)
            throw new IllegalArgumentException("The total quantity must not be less than 0");
        plants.put(name, (i != null ? i : 0) + amount);
        return this;
    }

    public Map<String, Integer> getPlants() {
        return plants;
    }
}

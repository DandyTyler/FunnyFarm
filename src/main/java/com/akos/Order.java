package com.akos;

import java.util.HashMap;
import java.util.Map;

/**
 * @author VYZH
 * @since 30.11.2017
 */
public class Order {

    private Map<String, Integer> plants = new HashMap<>();

    public Order add(String name, int amount) {
        Integer i = plants.get(name);
        plants.put(name, (i != null ? i : 0) + amount);
        // todo: throw exception if total amount goes bellow 0
        return this;
    }
}

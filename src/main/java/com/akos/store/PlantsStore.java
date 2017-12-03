package com.akos.store;

import com.akos.exceptions.NoSuchMoneyException;
import com.akos.plants.Plant;
import com.akos.plants.factories.PlantFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Магазин растений. Принимает заказы, и счет, с которогого списываются бонусы, возвращает корзину купленных растений
 */
public class PlantsStore {
    Map<String, PlantFactory> factoryMap = new HashMap<>();

    public static Cart buy(Order order, Account account) {
        Cart cart = new Cart();
        for (Map.Entry<String, Integer> entry : order.getPlants().entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                cart.add(create(entry.getKey(), account));
            }
        }
        return cart;
    }


    private static Plant create(String plantName, Account account) {
        try {
            Map<String, PlantFactory> factoryMap = new HashMap<>();
            if (!factoryMap.containsKey(plantName)) {
                Class<PlantFactory> cls = (Class<PlantFactory>) Class.forName("com.akos.plants.factories." + plantName + "Factory");
                factoryMap.put(plantName, cls.newInstance());
            }
            if (account.check(factoryMap.get(plantName).getCost())) {
                account.addBonuses(-factoryMap.get(plantName).getCost());
                return factoryMap.get(plantName).getPlant();
            }
            throw new NoSuchMoneyException("You have: " + account.getBonuses() + "; You need: " + factoryMap.get(plantName).getCost());
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | ClassCastException e) {
            throw new IllegalArgumentException("No such plant: " + plantName, e);
        }

    }
}

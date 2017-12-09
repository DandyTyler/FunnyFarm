package com.akos.store;

import com.akos.exceptions.NoSuchMoneyException;
import com.akos.plants.Plant;
import com.akos.plants.factories.PlantFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Магазин растений. Принимает заказы, и счет, с которогого списываются бонусы, возвращает корзину купленных растений
 */
public class PlantsStore {

    /**
     * Оплата заказа и получение корзины растений
     * @param order заказ
     * @param account счет, с котрого производится оплата
     * @return корзина купленных растений
     */
    public static Cart buy(Order order, Account account) {
        Cart cart = new Cart();
        int cartCost = 0;
        List<Plant> plants = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : order.getPlants().entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                String plantName = entry.getKey();

                PlantFactory plantFactory = getPlantFactory(plantName);
                cartCost += plantFactory.getCost();

                Plant plant = plantFactory.getPlant();
                plants.add(plant);
            }
        }
        if (!account.check(cartCost)) {
            throw new NoSuchMoneyException("Not enough bonuses. You have: " + account.getBonuses() + "; You need: " + cartCost);
        }
        cart.getPlantsList().addAll(plants);
        account.addBonuses(-cartCost);
        return cart;
    }

    private static PlantFactory getPlantFactory(String plantName) {
        try {
            Class<PlantFactory> cls = (Class<PlantFactory>) Class.forName("com.akos.plants.factories." + plantName + "Factory");
            return cls.newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | ClassCastException e) {
            throw new IllegalArgumentException("No such plant: " + plantName, e);
        }

    }

}

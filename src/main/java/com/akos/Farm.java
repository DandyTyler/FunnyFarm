package com.akos;

import com.akos.exceptions.NoSuchMoneyException;
import com.akos.plants.PlantsFactory;

public class Farm {
    private Storage storage = new Storage();
    private Garden garden = new Garden();
    private int bonuses;

    public Farm(int bonuses) {
        this.bonuses = bonuses;
    }

    /**
     * Собираем урожай и помещаем его на склад
     */
    public void doHarvest() {
        storage.sendToStorage(garden.harvest());
    }

    /**
     * Продаем со склада урожай конкретного растения, по определенной цене за еденицу и получаем за это бонусы
     */
    public void sellHarvest(PlantsData pd, int price) {
        bonuses = bonuses + storage.removeFromStorage(pd.getName()) * price;
    }

    /**
     * Покупаем нужное количество растений за бонусы и сажаем их в огород
     *
     * @param pd       информация о покупаемом растении(название, стоимость)
     * @param quantity количество покупаемых растений
     */
    public void buyAndPlant(PlantsData pd, int quantity) {
        if (calcLoss(pd.getCost(), quantity) > bonuses)
            throw new NoSuchMoneyException("You have: " + bonuses);
        bonuses -= (calcLoss(pd.getCost(), quantity));
        for (int i = 0; i < quantity; i++) {
            garden.plant(PlantsFactory.create(pd.getName()));
        }
    }

    public int getBonuses() {
        return bonuses;
    }

    /**
     * Рассчитывает затраты на покупку растений
     *
     * @param cost     цена за единицу
     * @param quantity
     * @return убыток
     */
    private int calcLoss(int cost, int quantity) {
        return cost * quantity;
    }
}

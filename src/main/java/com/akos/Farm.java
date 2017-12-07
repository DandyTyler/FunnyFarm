package com.akos;

import com.akos.exceptions.NoSuchMoneyException;
import com.akos.plants.Plant;
import com.akos.store.Account;
import com.akos.store.Cart;
import com.akos.store.Order;
import com.akos.store.PlantsStore;
import com.akos.ui.Command;
import com.akos.ui.CommandArgument;

/**
 * Ферма. Содержит огород и склад для урожая, имеет некоторое количество бонусов. Можно собирать урожай и помещать его не склад, продавать урожа со склада,
 * получая бонусы, тратить бонусы на окупку новых растений
 */
public class Farm {
    private Storage storage = new Storage();
    private Garden garden = new Garden(new Conditions(65, 20, 400, Seasons.SUMMER));
    private Account account = new Account();


    /**
     * При создании фермы можно определить начальное количество бонусов
     *
     * @param bonuses начальное количество бонусов
     */
    public Farm(int bonuses) {
        account.addBonuses(bonuses);
        ;
    }

    public void setGardenContions(Conditions conditions) {
        garden.setConditions(conditions);
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
    @Command({
            @CommandArgument("Enter plantName: "),
            @CommandArgument("Enter price: ")
    })
    public void sellHarvest(String plantName, int price) {
        account.addBonuses(storage.removeFromStorage(plantName) * price);
    }

    /**
     * Покупаем нужное количество растений за бонусы и сажаем их в огород
     *
     * @param order заказ, содержаший список покупаемых растений и их количество
     */
    public void buyAndPlant(Order order) {
        Cart cart = PlantsStore.buy(order, account);
        for (Plant p : cart.getPlantsList()) {
            garden.plant(p);
        }
    }

    public int getBonuses() {
        return account.getBonuses();
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

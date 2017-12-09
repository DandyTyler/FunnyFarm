package com.akos.store;

/**
 * Счет в которм хранятся бонусы
 */
public class Account {

    private int bonuses = 0;

    /**
     * Узнать сколько бонусов на счету
     *
     * @return количество бонусов
     */
    public int getBonuses() {
        return this.bonuses;
    }

    /**
     * Поменять количество бонусов на счету
     *
     * @param bonuses добавляемое количество бонусов
     */
    public void addBonuses(int bonuses) {
        this.bonuses += bonuses;
    }

    /**
     * Хватает ли бонусов на счете
     *
     * @param amount
     * @return хватает ли бонусов на счете
     */
    public boolean check(int amount) {
        return amount <= bonuses;
    }
}
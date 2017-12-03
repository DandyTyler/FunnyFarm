package com.akos.store;

/**
 * Счет в которм хранятся бонусы
 */
public class Account {
    private int bonuses = 0;

    public int getBonuses() {
        return this.bonuses;
    }

    public void addBonuses(int bonuses) {
        this.bonuses += bonuses;
    }

    /**
     * Хватает ли бонусов на счете
     *
     * @param amount
     * @return
     */
    public boolean check(int amount) {
        if (amount > bonuses)
            return false;
        return true;
    }
}
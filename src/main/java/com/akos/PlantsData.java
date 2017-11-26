package com.akos;

/**
 * Хранит цену покупки и названия растений
 */
public enum PlantsData {
    CARROT("Carrot", 2), POTATO("Potato", 4);

    private PlantsData(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    private final String name;
    private final int cost;

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }
}
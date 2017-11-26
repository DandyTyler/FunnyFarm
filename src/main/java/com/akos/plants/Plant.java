package com.akos.plants;

public interface Plant {
    String getName();

    /**
     * Готово ли растение к сборке урожая
     *
     * @return готово или нет
     */
    boolean isReady();

    /**
     * Растение растет
     */
    void grow();
}

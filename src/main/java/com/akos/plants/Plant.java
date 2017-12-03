package com.akos.plants;

import com.akos.Conditions;

/**
 * Растение. Может расти и становиться готовым к сборке
 */
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

    void setConditions(Conditions conditions);
}

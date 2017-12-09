package com.akos.plants;

import com.akos.Conditions;

/**
 * Растение. Может расти и становиться готовым к сборке. Растения могут быть полезными для здоровья,
 * если в них содержится много витаминов.
 */
public interface Plant {

    /**
     * Каждое растение имеет название
     *
     * @return название растения
     */
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

    /**
     * Условия, в которых растет растение
     *
     * @param conditions условия
     */
    void setConditions(Conditions conditions);

}

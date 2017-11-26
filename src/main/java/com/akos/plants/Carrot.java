package com.akos.plants;

/**
 * /Морковь. Готова к сборке если размер больше 3
 */
public class Carrot implements Plant {
    private String name = "Carrot";
    private int size = 0;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isReady() {
        return size > 0;
    }

    @Override
    public void grow() {
        size++;
    }
}

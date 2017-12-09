package com.akos.plants;

/**
 * Фрукт. Во фруктах есть витамин С. Фрукты полезны для здоровья, если витамина С больше 50.
 */
public abstract class Fruit implements Plant {

    /**
     *
     * @return содержание витамина С
     */
    public abstract int getVitaminC();

    /**
     * Полезен ли фрукт
     * @return
     */
    public boolean IsHealthy(){
        return getVitaminC()>50;
    }

    @Override
    public String toString() {
        return this.getName()+ (this.isReady()? " is ready":" is not ready") +  ",vitamin C = " + getVitaminC();
    }
}

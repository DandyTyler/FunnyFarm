package com.akos.plants;

/**
 * Фрукт. Во фруктах есть витамин С
 */
public abstract class Fruit implements Plant {
    public abstract int getVitaminC();

    @Override
    public String toString() {
        return this.getName()+ (this.isReady()? "is ready":"is not ready") +  ",vitamin C = " + getVitaminC();
    }
}

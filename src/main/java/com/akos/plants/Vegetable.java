package com.akos.plants;

/**
 * Овощ. В овощах содержится витамин B(наверное)
 */
public abstract class Vegetable implements Plant {
    public abstract int getVitaminB();

    @Override
    public String toString() {
        return this.getName() + (this.isReady() ? "(is ready)" : "(is not ready)") + ",vitamin B = " + getVitaminB();
    }
}

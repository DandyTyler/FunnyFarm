package com.akos.plants;

/**
 * Овощ. В овощах содержится витамин B(наверное). Овощи полезны, если витамина B больше 80
 */
public abstract class Vegetable implements Plant {

    /**
     * @return содержание витамина B
     */
    public abstract int getVitaminB();

    public boolean IsHealthy(){
        return getVitaminB()>80;
    }

    @Override
    public String toString() {
        return this.getName() + (this.isReady() ? "(is ready)" : "(is not ready)") + ",vitamin B = " + getVitaminB();
    }
}

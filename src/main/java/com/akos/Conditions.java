package com.akos;

/**
 * Условия, в которых растут растения
 */
public class Conditions {
    private Seasons season;
    private int humidity;
    private int temperature;
    private int illumination;

    public Conditions(int humidity, int temperature, int illumination, Seasons season) {
        this.humidity = humidity;
        this.temperature = temperature;
        this.illumination = illumination;
        this.season = season;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getIllumination() {
        return illumination;
    }

    public void setIllumination(int illumination) {
        this.illumination = illumination;
    }

    public Seasons getSeason() {
        return season;
    }

    public void setSeason(Seasons season) {
        this.season = season;
    }
}

package com.ifood.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

import java.io.Serializable;

public class MainResponse implements Serializable {

    private static final long serialVersionUID = 7800455209786049081L;

    @JsonProperty("temp")
    private double temperature;

    private double pressure;

    private int humidity;

    @JsonProperty("temp_min")
    private double minimumTemperature;

    @JsonProperty("temp_max")
    private double maximumTemperature;

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public double getMinimumTemperature() {
        return minimumTemperature;
    }

    public void setMinimumTemperature(double temp_min) {
        this.minimumTemperature = temp_min;
    }

    public double getMaximumTemperature() {
        return maximumTemperature;
    }

    public void setMaximumTemperature(double temp_max) {
        this.maximumTemperature = temp_max;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("temperature", temperature)
                .add("pressure", pressure)
                .add("humidity", humidity)
                .add("minimumTemperature", minimumTemperature)
                .add("maximumTemperature", maximumTemperature)
                .toString();
    }
}
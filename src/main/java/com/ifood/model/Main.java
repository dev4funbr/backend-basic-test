package com.ifood.model;

import com.google.common.base.MoreObjects;

import java.io.Serializable;

public class Main implements Serializable {

    private static final long serialVersionUID = 1705750909274413555L;

    private final double temperature;

    private final double pressure;

    private final int humidity;

    private final double minimumTemperature;

    private final double maximumTemperature;

    private Main(Builder builder) {
        this.temperature = builder.temperature;
        this.pressure = builder.pressure;
        this.humidity = builder.humidity;
        this.minimumTemperature = builder.minimumTemperature;
        this.maximumTemperature = builder.maximumTemperature;
    }

    public static Builder builder() {
        return new Builder();
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

    public double getTemperature() {
        return temperature;
    }

    public double getPressure() {
        return pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public double getMinimumTemperature() {
        return minimumTemperature;
    }

    public double getMaximumTemperature() {
        return maximumTemperature;
    }

    public static class Builder {
        private double temperature;
        private double pressure;
        private int humidity;
        private double minimumTemperature;
        private double maximumTemperature;

        private Builder() {
        }

        public Builder withTemperature(double temperature) {
            this.temperature = temperature;
            return this;
        }

        public Builder withPressure(double pressure) {
            this.pressure = pressure;
            return this;
        }

        public Builder withHumidity(int humidity) {
            this.humidity = humidity;
            return this;
        }

        public Builder withMinimumTemperature(double minimumTemperature) {
            this.minimumTemperature = minimumTemperature;
            return this;
        }

        public Builder withMaximumTemperature(double maximumTemperature) {
            this.maximumTemperature = maximumTemperature;
            return this;
        }

        public Builder of(Main main) {
            this.temperature = main.temperature;
            this.pressure = main.pressure;
            this.humidity = main.humidity;
            this.minimumTemperature = main.minimumTemperature;
            this.maximumTemperature = main.maximumTemperature;
            return this;
        }

        public Main build() {
            return new Main(this);
        }
    }
}
package com.ifood.controller;

import com.ifood.model.WeatherInformation;

public class WeatherInfoResponse {

    private final String description;
    private final Double temperature;
    private final Double maxTemperature;
    private final Double minTemperature;
    private final Integer humidity;
    private final Double pressure;

    private WeatherInfoResponse(Builder builder) {
        this.description = builder.description;
        this.temperature = builder.temperature;
        this.humidity = builder.humidity;
        this.pressure = builder.pressure;
        this.maxTemperature = builder.maxTemperature;
        this.minTemperature = builder.minTemperature;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getDescription() {
        return description;
    }

    public Double getTemperature() {
        return temperature;
    }

    public Double getMaxTemperature() {
        return maxTemperature;
    }

    public Double getMinTemperature() {
        return minTemperature;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public Double getPressure() {
        return pressure;
    }


    public static class Builder {
        private String description;
        private Double temperature;
        private Double maxTemperature;
        private Double minTemperature;
        private Integer humidity;
        private Double pressure;

        private Builder() {
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withTemperature(Double temperature) {
            this.temperature = temperature;
            return this;
        }

        public Builder withHumidity(Integer humidity) {
            this.humidity = humidity;
            return this;
        }

        public Builder withPressure(Double pressure) {
            this.pressure = pressure;
            return this;
        }

        public Builder withMaxTemperature(Double maxTemperature) {
            this.maxTemperature = maxTemperature;
            return this;
        }

        public Builder withMinTemperature(Double minTemperature) {
            this.minTemperature = minTemperature;
            return this;
        }

        public Builder of(WeatherInformation weatherInformation) {
            this.description = !weatherInformation.getWeathers().isEmpty() ? weatherInformation.getWeathers().get(0).getDescription() : "Undefined";
            this.temperature = weatherInformation.getMain().getTemperature();
            this.maxTemperature = weatherInformation.getMain().getMaximumTemperature();
            this.minTemperature = weatherInformation.getMain().getMinimumTemperature();
            this.humidity = weatherInformation.getMain().getHumidity();
            this.pressure = weatherInformation.getMain().getPressure();
            return this;
        }

        public WeatherInfoResponse build() {
            return new WeatherInfoResponse(this);
        }
    }
}

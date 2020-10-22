package com.ifood.model;

import java.io.Serializable;
import java.util.List;

public class WeatherInformation implements Serializable {

    private static final long serialVersionUID = -4591281869949734844L;

    private final Long id;

    private final String name;

    private final List<CurrentWeather> weathers;

    private final Main main;

    private final long visibility;

    private final Wind wind;

    private final long epochTime;

    private WeatherInformation(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.weathers = builder.currentWeather;
        this.main = builder.main;
        this.visibility = builder.visibility;
        this.wind = builder.wind;
        this.epochTime = builder.epochTime;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<CurrentWeather> getWeathers() {
        return weathers;
    }

    public Main getMain() {
        return main;
    }

    public long getVisibility() {
        return visibility;
    }

    public Wind getWind() {
        return wind;
    }

    public long getEpochTime() {
        return epochTime;
    }

    public static class Builder {
        private Long id;
        private String name;
        private List<CurrentWeather> currentWeather;
        private Main main;
        private long visibility;
        private Wind wind;
        private long epochTime;

        private Builder() {
        }

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withCurrentWeather(List<CurrentWeather> currentWeather) {
            this.currentWeather = currentWeather;
            return this;
        }

        public Builder withMain(Main main) {
            this.main = main;
            return this;
        }

        public Builder withVisibility(long visibility) {
            this.visibility = visibility;
            return this;
        }

        public Builder withWind(Wind wind) {
            this.wind = wind;
            return this;
        }

        public Builder withEpochTime(long epochTime) {
            this.epochTime = epochTime;
            return this;
        }

        public Builder of(WeatherInformation weatherInformation) {
            this.id = weatherInformation.id;
            this.name = weatherInformation.name;
            this.currentWeather = weatherInformation.weathers;
            this.main = weatherInformation.main;
            this.visibility = weatherInformation.visibility;
            this.wind = weatherInformation.wind;
            this.epochTime = weatherInformation.epochTime;
            return this;
        }

        public WeatherInformation build() {
            return new WeatherInformation(this);
        }
    }
}

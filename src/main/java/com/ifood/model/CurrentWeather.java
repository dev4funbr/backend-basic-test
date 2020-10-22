package com.ifood.model;

import com.google.common.base.MoreObjects;

import java.io.Serializable;

public class CurrentWeather implements Serializable {

    private static final long serialVersionUID = 8525697565808228652L;

    private final String weatherGroup;

    private final String description;

    private CurrentWeather(Builder builder) {
        this.weatherGroup = builder.weatherGroup;
        this.description = builder.description;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("weatherGroup", weatherGroup)
                .add("description", description)
                .toString();
    }

    public String getWeatherGroup() {
        return weatherGroup;
    }

    public String getDescription() {
        return description;
    }

    public static class Builder {
        private String weatherGroup;
        private String description;

        private Builder() {
        }

        public Builder withWeatherGroup(String weatherGroup) {
            this.weatherGroup = weatherGroup;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder of(CurrentWeather currentWeather) {
            this.weatherGroup = currentWeather.weatherGroup;
            this.description = currentWeather.description;
            return this;
        }

        public CurrentWeather build() {
            return new CurrentWeather(this);
        }
    }
}
package com.ifood.client;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class WeatherInformationResponse implements Serializable {
    private static final long serialVersionUID = 6871501723881249566L;

    private Long id;

    private String name;

    @JsonProperty("weather")
    private List<CurrentWeatherResponse> weather;

    private MainResponse main;

    private long visibility;

    private WindResponse wind;

    @JsonProperty("dt")
    private long epochTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CurrentWeatherResponse> getWeather() {
        return weather;
    }

    public void setWeather(List<CurrentWeatherResponse> weather) {
        this.weather = weather;
    }

    public MainResponse getMain() {
        return main;
    }

    public void setMain(MainResponse main) {
        this.main = main;
    }

    public long getVisibility() {
        return visibility;
    }

    public void setVisibility(long visibility) {
        this.visibility = visibility;
    }

    public WindResponse getWind() {
        return wind;
    }

    public void setWind(WindResponse wind) {
        this.wind = wind;
    }

    public long getEpochTime() {
        return epochTime;
    }

    public void setEpochTime(long epochTime) {
        this.epochTime = epochTime;
    }

    public void addCurrentWeather(CurrentWeatherResponse currentWeatherResponse) {
        if(weather == null) weather = new ArrayList<>();

        weather.add(currentWeatherResponse);
    }
}

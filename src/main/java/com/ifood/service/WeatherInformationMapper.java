package com.ifood.service;

import com.ifood.client.CurrentWeatherResponse;
import com.ifood.client.MainResponse;
import com.ifood.client.WeatherInformationResponse;
import com.ifood.client.WindResponse;
import com.ifood.model.CurrentWeather;
import com.ifood.model.Main;
import com.ifood.model.WeatherInformation;
import com.ifood.model.Wind;

import java.util.List;
import java.util.stream.Collectors;

public class WeatherInformationMapper {

    public static WeatherInformation weatherResponseToWeather(final WeatherInformationResponse weatherInformationResponse) {
        List<CurrentWeather> currentWeatherList = weatherInformationResponse
                .getWeather().stream().map(WeatherInformationMapper::getCurrentWeather)
                .collect(Collectors.toList());
        return WeatherInformation.builder()
                .withCurrentWeather(currentWeatherList)
                .withEpochTime(weatherInformationResponse.getEpochTime())
                .withId(weatherInformationResponse.getId())
                .withMain(getWeatherMain(weatherInformationResponse.getMain()))
                .withName(weatherInformationResponse.getName())
                .withVisibility(weatherInformationResponse.getVisibility())
                .withWind(getWind(weatherInformationResponse.getWind()))
                .build();
    }

    private static Main getWeatherMain(MainResponse main) {
        return Main.builder()
                .withHumidity(main.getHumidity())
                .withMaximumTemperature(main.getMaximumTemperature())
                .withMinimumTemperature(main.getMinimumTemperature())
                .withPressure(main.getPressure())
                .withTemperature(main.getTemperature())
                .build();
    }

    private static Wind getWind(WindResponse wind) {
        return new Wind(wind.getSpeed());
    }

    private static CurrentWeather getCurrentWeather(CurrentWeatherResponse currentWeatherResponse) {
        return CurrentWeather.builder()
                .withDescription(currentWeatherResponse.getDescription())
                .withWeatherGroup(currentWeatherResponse.getMain())
                .build();
    }
}

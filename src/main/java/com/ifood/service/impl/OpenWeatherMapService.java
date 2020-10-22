package com.ifood.service.impl;

import com.ifood.client.OpenWeatherMapClient;
import com.ifood.client.WeatherInformationResponse;
import com.ifood.model.WeatherInformation;
import com.ifood.service.WeatherInformationMapper;
import com.ifood.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OpenWeatherMapService implements WeatherService {

    private OpenWeatherMapClient openWeatherMapClient;
    private final String appKey;
    private final String unit;

    @Autowired
    public OpenWeatherMapService(OpenWeatherMapClient openWeatherMapClient,
                                 @Value("${client.openweathermap.key}") String appKey,
                                 @Value("${client.openweathermap.unit}") String unit) {
        this.openWeatherMapClient = openWeatherMapClient;
        this.appKey = appKey;
        this.unit = unit;
    }

    @Override
    public WeatherInformation findWeatherByCity(String city) {
        WeatherInformationResponse weatherResponse = openWeatherMapClient.getWeatherInfo(city, appKey, unit);
        return WeatherInformationMapper.weatherResponseToWeather(weatherResponse);
    }
}

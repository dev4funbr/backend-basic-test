package com.ifood.service;

import com.ifood.model.WeatherInformation;

public interface WeatherService {
    WeatherInformation findWeatherByCity(String city);
}
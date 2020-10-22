package com.ifood.controller;

import com.ifood.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/weather")
public class WeatherControllerImpl implements WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherControllerImpl(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public WeatherInfoResponse getWeather(@RequestParam(value = "cityName") String cityName) {
        return WeatherInfoResponse.builder().of(weatherService.findWeatherByCity(cityName)).build();
    }
}

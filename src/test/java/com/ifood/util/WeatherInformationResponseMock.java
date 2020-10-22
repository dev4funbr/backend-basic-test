package com.ifood.util;

import com.ifood.client.CurrentWeatherResponse;
import com.ifood.client.MainResponse;
import com.ifood.client.WeatherInformationResponse;
import com.ifood.client.WindResponse;

import java.util.ArrayList;
import java.util.List;

public class WeatherInformationResponseMock {

    public static WeatherInformationResponse newMock() {
        WeatherInformationResponse weatherInformationResponse = new WeatherInformationResponse();
        CurrentWeatherResponse currentWeatherResponse = new CurrentWeatherResponse();
        currentWeatherResponse.setDescription("Desc Teste");
        currentWeatherResponse.setMain("Group Teste");
        List<CurrentWeatherResponse> currentWeatherResponseList= new ArrayList<>();
        currentWeatherResponseList.add(currentWeatherResponse);
        weatherInformationResponse.setWeather(currentWeatherResponseList);
        long epochTime = System.currentTimeMillis();
        weatherInformationResponse.setEpochTime(epochTime);
        weatherInformationResponse.setId(Long.valueOf(1));
        MainResponse mainResponse = new MainResponse();
        mainResponse.setHumidity(1);
        mainResponse.setMaximumTemperature(30);
        mainResponse.setMinimumTemperature(20);
        mainResponse.setPressure(100);
        mainResponse.setTemperature(26);
        weatherInformationResponse.setMain(mainResponse);
        weatherInformationResponse.setName("Teste");
        weatherInformationResponse.setVisibility(Long.valueOf(1));
        WindResponse wind = new WindResponse();
        wind.setSpeed(20.0);
        weatherInformationResponse.setWind(wind);
        return weatherInformationResponse;
    }
}

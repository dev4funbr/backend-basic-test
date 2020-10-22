package com.ifood.client;

import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class OpenWeatherMapFallbackFactory implements FallbackFactory<OpenWeatherMapClient>  {

    private static final Logger LOGGER = LoggerFactory.getLogger(OpenWeatherMapFallbackFactory.class);

    @Override
    public OpenWeatherMapClient create(Throwable throwable) {

        return new OpenWeatherMapClient() {

            @Override
            public WeatherInformationResponse getWeatherInfo(String cityName, String appkey, String units) {
                LOGGER.error(throwable.getMessage());
                final WeatherInformationResponse weatherInformationResponse = new WeatherInformationResponse();
                final CurrentWeatherResponse currentWeatherResponse = new CurrentWeatherResponse();
                currentWeatherResponse.setDescription("Error: Weather Service Unavailable");
                weatherInformationResponse.addCurrentWeather(currentWeatherResponse);
                weatherInformationResponse.setWind(new WindResponse());
                weatherInformationResponse.setMain(new MainResponse());
                return weatherInformationResponse;
            }
        };
    }
}

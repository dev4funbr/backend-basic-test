package com.ifood.client;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "openWeatherMapClient",
        url = "${client.openweathermap.url}",
        fallbackFactory = OpenWeatherMapFallbackFactory.class
)
public interface OpenWeatherMapClient {

    @RequestMapping(method = RequestMethod.GET, value = "/weather?q={cityName}&appid={appid}&units={units}")
    @Cacheable(value = "weathers", unless = "#result.weather.get(0).description eq 'Error: Weather Service Unavailable'")
    WeatherInformationResponse getWeatherInfo(
            @RequestParam(value = "cityName") String cityName,
            @RequestParam(value="appid") String appid,
            @RequestParam(value = "units") String units);
}

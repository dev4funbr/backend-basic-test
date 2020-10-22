package com.ifood.controller;

import com.ifood.client.OpenWeatherMapClient;
import com.ifood.client.WeatherInformationResponse;
import com.ifood.util.WeatherInformationResponseMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@SpringBootTest
@RunWith(SpringRunner.class)
public class WeatherControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Autowired
    private WeatherController weatherController;

    @MockBean
    private OpenWeatherMapClient openWeatherMapClient;

    @Before
    public void setup() {
        this.mockMvc = standaloneSetup(this.weatherController).build();
    }

    @Test
    public void givenHealthApi_whenCheckHealth_thenReturnOk() throws Exception {
        final WeatherInformationResponse weatherInformationResponse = WeatherInformationResponseMock.newMock();
        final String cityName = "London";
        when(openWeatherMapClient.getWeatherInfo(cityName, "apptestekey", "metric")).thenReturn(weatherInformationResponse);
        MvcResult mvcResult = this.mockMvc.perform(get("/weather?cityName=" + cityName))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.description").value(weatherInformationResponse.getWeather().get(0).getDescription()))
                .andExpect(jsonPath("$.humidity").value(weatherInformationResponse.getMain().getHumidity()))
                .andExpect(jsonPath("$.temperature").value(weatherInformationResponse.getMain().getTemperature()))
                .andExpect(jsonPath("$.maxTemperature").value(weatherInformationResponse.getMain().getMaximumTemperature()))
                .andExpect(jsonPath("$.minTemperature").value(weatherInformationResponse.getMain().getMinimumTemperature()))
                .andExpect(jsonPath("$.pressure").value(weatherInformationResponse.getMain().getPressure()))
                .andReturn();

    }
}
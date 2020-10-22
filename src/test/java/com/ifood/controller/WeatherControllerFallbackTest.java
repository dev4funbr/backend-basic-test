package com.ifood.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestPropertySource(properties = "client.openweathermap.key=123")

public class WeatherControllerFallbackTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Autowired
    private WeatherController weatherController;

    @Before
    public void setup() {
        this.mockMvc = standaloneSetup(this.weatherController).build();
    }

    @Test
    public void givenCity_whenWeatherServiceIsDown_thenReturnError() throws Exception {
        final String cityName = "London";
        MvcResult mvcResult = this.mockMvc.perform(get("/weather?cityName=" + cityName))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.description").value("Error: Weather Service Unavailable"))
                .andReturn();

    }
}
package com.ifood.service;

import com.ifood.client.WeatherInformationResponse;
import com.ifood.model.WeatherInformation;
import com.ifood.util.WeatherInformationResponseMock;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WeatherInformationMapperTest {

    @Test
    public void shouldMapCarToDto() {
        //given
        final WeatherInformationResponse weatherInformationResponse = WeatherInformationResponseMock.newMock();

        //when
        final WeatherInformation weather = WeatherInformationMapper.weatherResponseToWeather( weatherInformationResponse );

        //then
        assertThat( weather ).isNotNull();
        assertThat( weather.getWeathers().size() ).isEqualTo(1);
        assertThat( weather.getWeathers().get(0).getDescription() ).isEqualTo("Desc Teste");
        assertThat( weather.getWeathers().get(0).getWeatherGroup() ).isEqualTo("Group Teste");
        assertThat( weather.getEpochTime() ).isEqualTo( weatherInformationResponse.getEpochTime() );
        assertThat( weather.getMain().getMaximumTemperature() ).isEqualTo( 30 );
        assertThat( weather.getMain().getMinimumTemperature() ).isEqualTo( 20 );
        assertThat( weather.getMain().getHumidity() ).isEqualTo( 1 );
        assertThat( weather.getMain().getPressure() ).isEqualTo( 100 );
        assertThat( weather.getMain().getTemperature() ).isEqualTo( 26 );
        assertThat( weather.getWind().getSpeed() ).isEqualTo( 20.0 );
    }
}
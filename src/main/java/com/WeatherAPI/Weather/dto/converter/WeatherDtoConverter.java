package com.WeatherAPI.Weather.dto.converter;

import com.WeatherAPI.Weather.dto.WeatherDto;
import com.WeatherAPI.Weather.exception.ResourceNotFoundException;
import com.WeatherAPI.Weather.model.City;
import com.WeatherAPI.Weather.model.District;
import com.WeatherAPI.Weather.model.Weather;
import com.WeatherAPI.Weather.repository.CityRepository;
import com.WeatherAPI.Weather.repository.DistrictRepository;

import org.springframework.stereotype.Component;

@Component
public class WeatherDtoConverter {
    private final CityRepository cityRepository;
    private final DistrictRepository districtRepository;
    public WeatherDtoConverter(CityRepository cityRepository, DistrictRepository districtRepository) {
        this.cityRepository = cityRepository;
        this.districtRepository = districtRepository;
    }
    public WeatherDto convertToDto (Weather weather){
        WeatherDto weatherDto = new WeatherDto();
        weatherDto.setId(weather.getId());
        weatherDto.setDistrictId(weather.getDistrict().getId());
        weatherDto.setCityId(weather.getCity().getId());
        weatherDto.setDate(weather.getDate());
        weatherDto.setHour(weather.getHour());
        weatherDto.setName(weather.getName());
        weatherDto.setTemperature(weather.getTemperature());
        weatherDto.setFeltTemperature(weather.getFeltTemperature());
        weatherDto.setHumidity(weather.getHumidity());
        weatherDto.setWindDirection(weather.getWindDirection());
        weatherDto.setMaxWind(weather.getMaxWind());
        weatherDto.setAverageWind(weather.getAverageWind());
        return weatherDto;
    }
    public Weather convertToModel (WeatherDto weatherDto){
        City city = cityRepository.findById(weatherDto.getCityId())
            .orElseThrow(()->new ResourceNotFoundException("City","Id",weatherDto.getCityId()));
        District district = districtRepository.findById(weatherDto.getDistrictId())
            .orElseThrow(()->new ResourceNotFoundException("District","Id",weatherDto.getDistrictId()));
        Weather weather = new Weather();
        weather.setId(weatherDto.getId());
        weather.setDistrict(district);
        weather.setCity(city);
        weather.setDate(weatherDto.getDate());
        weather.setHour(weatherDto.getHour());
        weather.setName(weatherDto.getName());
        weather.setTemperature(weatherDto.getTemperature());
        weather.setFeltTemperature(weatherDto.getFeltTemperature());
        weather.setHumidity(weatherDto.getHumidity());
        weather.setWindDirection(weatherDto.getWindDirection());
        weather.setMaxWind(weatherDto.getMaxWind());
        weather.setAverageWind(weatherDto.getAverageWind());
        return weather;
    }
}

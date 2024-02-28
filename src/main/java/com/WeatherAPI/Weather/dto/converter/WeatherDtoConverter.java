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
        return WeatherDto.builder()
        .id(weather.getId())
        .districtId(weather.getDistrict().getId())
        .cityId(weather.getCity().getId())
        .date(weather.getDate())
        .hour(weather.getHour())
        .name(weather.getName())
        .temperature(weather.getTemperature())
        .feltTemperature(weather.getFeltTemperature())
        .humidity(weather.getHumidity())
        .windDirection(weather.getWindDirection())
        .maxWind(weather.getMaxWind())
        .averageWind(weather.getAverageWind())
        .build();
    }
    public Weather convertToModel (WeatherDto weatherDto){
        City city = cityRepository.findById(weatherDto.getCityId())
            .orElseThrow(()->new ResourceNotFoundException("City","Id",weatherDto.getCityId()));
        District district = districtRepository.findById(weatherDto.getDistrictId())
            .orElseThrow(()->new ResourceNotFoundException("District","Id",weatherDto.getDistrictId()));
        return Weather.builder()
        .id(weatherDto.getId())
        .district(district)
        .city(city)
        .date(weatherDto.getDate())
        .hour(weatherDto.getHour())
        .name(weatherDto.getName())
        .temperature(weatherDto.getTemperature())
        .feltTemperature(weatherDto.getFeltTemperature())
        .humidity(weatherDto.getHumidity())
        .windDirection(weatherDto.getWindDirection())
        .maxWind(weatherDto.getMaxWind())
        .averageWind(weatherDto.getAverageWind())
        .build();
    }
}

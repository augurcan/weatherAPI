package com.WeatherAPI.Weather.service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.WeatherAPI.Weather.dto.WeatherDto;
import com.WeatherAPI.Weather.dto.converter.WeatherDtoConverter;
import com.WeatherAPI.Weather.exception.ResourceNotFoundException;
import com.WeatherAPI.Weather.model.Weather;
import com.WeatherAPI.Weather.repository.WeatherRepository;

@Service
public class WeatherService {
    private final WeatherRepository weatherRepository;
    private final WeatherDtoConverter weatherDtoConverter;

    public WeatherService(WeatherRepository weatherRepository, WeatherDtoConverter weatherDtoConverter) {
        this.weatherRepository = weatherRepository;
        this.weatherDtoConverter = weatherDtoConverter;
    }
    public WeatherDto addWeather(WeatherDto weatherDto){
        Weather weather = weatherDtoConverter.convertToModel(weatherDto);
        Weather savedWeather= weatherRepository.save(weather);
        return weatherDtoConverter.convertToDto(savedWeather);
    }
    public WeatherDto updateWeather(WeatherDto weatherDto, Long id){
        Weather weather = weatherRepository.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("Weather", "Id", id));
        Weather.builder()
            .name(weatherDto.getName())
            .date(weatherDto.getDate())
            .hour(weatherDto.getHour())
            .temperature(weatherDto.getTemperature())
            .feltTemperature(weatherDto.getFeltTemperature())
            .humidity(weatherDto.getHumidity())
            .windDirection(weatherDto.getWindDirection())
            .maxWind(weatherDto.getMaxWind())
            .averageWind(weatherDto.getAverageWind())
            .build();
        Weather savedWeather = weatherRepository.save(weather);
        return weatherDtoConverter.convertToDto(savedWeather);
    }
    public void deleteWeather(Long id){
        Weather weather = weatherRepository.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("Weather", "Id", id));
        weatherRepository.delete(weather);
    }
    public WeatherDto getWeather(Long id){
        Weather weather = weatherRepository.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("Weather", "Id", id));
        return weatherDtoConverter.convertToDto(weather);
    }
    public List<WeatherDto> getAllWeather(){
        List<Weather> weathers = weatherRepository.findAll();
        return convertToWeatherDtoList(weathers);
    }
    public List<WeatherDto> getAllWeatherByDistrict(int districtId){
        List<Weather> weathers = weatherRepository.findByDistrictId(districtId);
        return convertToWeatherDtoList(weathers);
    }
    public List<WeatherDto> getAllWeatherByDistrictAndDate(int districtId, LocalDate date){
        List<Weather> weathers = weatherRepository.findByDistrictIdAndDate(districtId, date);
        return convertToWeatherDtoList(weathers);
    }
    public List<WeatherDto> getAllWeatherByCity(int cityId){
        List<Weather> weathers = weatherRepository.findByCityId(cityId);
        return convertToWeatherDtoList(weathers);
    }
    public List<WeatherDto> getAllWeatherByCityAndDate(int cityId, LocalDate date){
        List<Weather> weathers = weatherRepository.findByCityIdAndDate(cityId, date);
        return convertToWeatherDtoList(weathers);
    }
    private List<WeatherDto> convertToWeatherDtoList(List<Weather> weathers) {
        return weathers.stream()
                .map(weather -> weatherDtoConverter.convertToDto(weather))
                .sorted(Comparator.comparing(WeatherDto::getId).reversed())
                .collect(Collectors.toList());
    }
}

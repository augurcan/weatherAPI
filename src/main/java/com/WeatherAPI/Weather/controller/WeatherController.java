package com.WeatherAPI.Weather.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.WeatherAPI.Weather.dto.WeatherDto;
import com.WeatherAPI.Weather.service.WeatherService;

@RestController
@RequestMapping("/api/v1/weather")
public class WeatherController {
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }
    @PostMapping
    public ResponseEntity<WeatherDto> addWeather(@RequestBody WeatherDto weatherDto){
        WeatherDto addedWeather = weatherService.addWeather(weatherDto);
        return new ResponseEntity<>(addedWeather,HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteWeather(@PathVariable("id") Long id){
        weatherService.deleteWeather(id);
        return ResponseEntity.ok("Weather deleted successfully");
    }
    @PutMapping("/{id}")
    public ResponseEntity<WeatherDto> updateWeather(@RequestBody WeatherDto weatherDto,@PathVariable("id") Long id){
        return ResponseEntity.ok(weatherService.updateWeather(weatherDto, id));
    }
    @GetMapping
    public ResponseEntity<List<WeatherDto>> getAllWeathers(){
        return ResponseEntity.ok(weatherService.getAllWeather());
    }
    @GetMapping("/{id}")
    public ResponseEntity<WeatherDto> getWeather(@PathVariable("id") long id){
        WeatherDto weatherDto = weatherService.getWeather(id);
        return ResponseEntity.ok(weatherDto);
    }
    @GetMapping("/cities/{cityId}")
    public ResponseEntity<List<WeatherDto>> getWeathersByCity(@PathVariable("cityId") int cityId){
        return ResponseEntity.ok(weatherService.getAllWeatherByCity(cityId));
    }
    @GetMapping("/district/{districtId}")
    public ResponseEntity<List<WeatherDto>> getWeathersByDistrict(@PathVariable("districtId") int districtId){
        return ResponseEntity.ok(weatherService.getAllWeatherByDistrict(districtId));
    }
    @GetMapping("/cities/{cityId}/{date}")
    public ResponseEntity<List<WeatherDto>> getWeathersByCityAndDate(@PathVariable("cityId") int cityId,@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
        return ResponseEntity.ok(weatherService.getAllWeatherByCityAndDate(cityId, date));
    }
    @GetMapping("/district/{districtId}/{date}")
    public ResponseEntity<List<WeatherDto>> getWeathersByDistrictAndDate(@PathVariable("districtId") int districtId,@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
        return ResponseEntity.ok(weatherService.getAllWeatherByDistrictAndDate(districtId,date));
    }
}

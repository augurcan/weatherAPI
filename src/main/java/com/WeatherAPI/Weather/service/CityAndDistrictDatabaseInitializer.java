package com.WeatherAPI.Weather.service;

import com.WeatherAPI.Weather.model.City;
import com.WeatherAPI.Weather.model.District;
import com.WeatherAPI.Weather.repository.CityRepository;
import com.WeatherAPI.Weather.repository.DistrictRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
public class CityAndDistrictDatabaseInitializer implements CommandLineRunner {
    private final CityRepository cityRepository;
    private final DistrictRepository districtRepository;

    public CityAndDistrictDatabaseInitializer(CityRepository cityRepository, DistrictRepository districtRepository) {
        this.cityRepository = cityRepository;
        this.districtRepository = districtRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        if(cityRepository.count()==0) addCityData();
        if(districtRepository.count()==0) addDistrictData();
    }

    public void addCityData(){
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<City>> typeReference = new TypeReference<List<City>>() {};
        InputStream inputStream= TypeReference.class.getResourceAsStream("/city.json");
        try{
            List<City> cityList = objectMapper.readValue(inputStream,typeReference);
            cityRepository.saveAll(cityList);
            System.out.println("Cities Added!");
        } catch (IOException e) {
            System.out.println("Unable to add cities: " + e.getMessage());
        }
    }

    public void addDistrictData(){
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<District>> typeReference = new TypeReference<List<District>>() {};
        InputStream inputStream= TypeReference.class.getResourceAsStream("/district.json");
        try{
            List<District> districtList = objectMapper.readValue(inputStream,typeReference);
            districtRepository.saveAll(districtList);
            System.out.println("Districts Added!");
        } catch (IOException e) {
            System.out.println("Unable to add districts: " + e.getMessage());
        }
    }
}

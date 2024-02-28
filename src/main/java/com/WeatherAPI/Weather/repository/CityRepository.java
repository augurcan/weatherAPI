package com.WeatherAPI.Weather.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.WeatherAPI.Weather.model.City;

public interface CityRepository extends JpaRepository<City,Integer>{
    
}

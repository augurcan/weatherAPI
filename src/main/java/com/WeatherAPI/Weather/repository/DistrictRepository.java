package com.WeatherAPI.Weather.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.WeatherAPI.Weather.model.District;

public interface DistrictRepository extends JpaRepository<District,Integer>{
    
}

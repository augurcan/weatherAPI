package com.WeatherAPI.Weather.repository;

import com.WeatherAPI.Weather.model.Weather;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepository extends JpaRepository<Weather,Long> {
    @Query("SELECT w FROM weather w WHERE w.district_id= :districtId")
    List<Weather> findByDistrictId(int districtId);
    @Query("SELECT w FROM weather w WHERE w.district_id= :districtId AND w.date=: date")
    List<Weather> findByDistrictIdAndDate(int districtId, LocalDate date);
    @Query("SELECT w FROM weather w WHERE w.city_id= :cityId")
    List<Weather> findByCityId(int cityId);
    @Query("SELECT w FROM weather w WHERE w.city_id= :cityId AND w.date=: date")
    List<Weather> findByCityIdAndDate(int cityId, LocalDate date);
}   

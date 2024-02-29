package com.WeatherAPI.Weather.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
public class WeatherDto {
    @NotNull
    private Long id;
    @NotNull
    private int districtId;
    @NotNull
    private int cityId;
    @NotNull
    private LocalDate date;
    @NotNull
    private int hour;
    @NotBlank
    private String name;
    @NotNull
    private int temperature;
    @NotNull
    private int feltTemperature;
    @NotNull
    private int humidity;
    @NotBlank
    private String windDirection;
    @NotNull
    private int maxWind;
    @NotNull
    private int averageWind;
    public WeatherDto() {
    }
    public WeatherDto(Long id, int districtId, int cityId,
                      LocalDate date, int hour, String name,
                      int temperature, int feltTemperature, int humidity,
                      String windDirection, int maxWind, int averageWind) {
        this.id = id;
        this.districtId = districtId;
        this.cityId = cityId;
        this.date = date;
        this.hour = hour;
        this.name = name;
        this.temperature = temperature;
        this.feltTemperature = feltTemperature;
        this.humidity = humidity;
        this.windDirection = windDirection;
        this.maxWind = maxWind;
        this.averageWind = averageWind;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getFeltTemperature() {
        return feltTemperature;
    }

    public void setFeltTemperature(int feltTemperature) {
        this.feltTemperature = feltTemperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public int getMaxWind() {
        return maxWind;
    }

    public void setMaxWind(int maxWind) {
        this.maxWind = maxWind;
    }

    public int getAverageWind() {
        return averageWind;
    }

    public void setAverageWind(int averageWind) {
        this.averageWind = averageWind;
    }
}

package com.WeatherAPI.Weather.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
@Entity
@Table(schema = "weather")
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @ManyToOne
    @JoinColumn(name="district_id")
    private District district;
    @NotNull
    @ManyToOne
    @JoinColumn(name="city_id")
    private City city;
    @NotNull
    @Column(name="date")
    private LocalDate date;
    @NotNull
    @Column(name="hour")
    private int hour;
    @NotBlank
    @Column(name="weather")
    private String name;
    @NotNull
    @Column(name="temperature")
    private int temperature;
    @NotNull
    @Column(name="felt_temperature")
    private int feltTemperature;
    @NotNull
    @Column(name="humidity")
    private int humidity;
    @NotBlank
    @Column(name="wind_direction")
    private String windDirection;
    @NotNull
    @Column(name="max_wind")
    private int maxWind;
    @NotNull
    @Column(name="average_wind")
    private int averageWind;

    public Weather() {
    }

    public Weather(Long id, District district, City city,
                   LocalDate date, int hour, String name,
                   int temperature, int feltTemperature, int humidity,
                   String windDirection, int maxWind, int averageWind) {
        this.id = id;
        this.district = district;
        this.city = city;
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

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
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

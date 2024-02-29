package com.WeatherAPI.Weather.model;

import jakarta.persistence.*;
import java.util.List;
@Entity
@Table(schema = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;
    @OneToMany(mappedBy = "city")
    private List<District> districtList;
    @OneToMany(mappedBy = "city")
    private List<Weather> weatherList;

    public City() {
    }

    public City(int id, String name, List<District> districtList, List<Weather> weatherList) {
        this.id = id;
        this.name = name;
        this.districtList = districtList;
        this.weatherList = weatherList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<District> getDistrictList() {
        return districtList;
    }

    public void setDistrictList(List<District> districtList) {
        this.districtList = districtList;
    }

    public List<Weather> getWeatherList() {
        return weatherList;
    }

    public void setWeatherList(List<Weather> weatherList) {
        this.weatherList = weatherList;
    }
}

package com.WeatherAPI.Weather.model;

import jakarta.persistence.*;
import java.util.List;
@Entity
@Table(schema = "district")
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;
    @ManyToOne
    @JoinColumn(name="city_id")
    private City city;
    @OneToMany(mappedBy = "district")
    private List<Weather> weatherList;

    public District() {
    }

    public District(int id, String name, City city, List<Weather> weatherList) {
        this.id = id;
        this.name = name;
        this.city = city;
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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Weather> getWeatherList() {
        return weatherList;
    }

    public void setWeatherList(List<Weather> weatherList) {
        this.weatherList = weatherList;
    }
}

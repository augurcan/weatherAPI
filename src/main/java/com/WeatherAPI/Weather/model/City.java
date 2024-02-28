package com.WeatherAPI.Weather.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Data
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
}

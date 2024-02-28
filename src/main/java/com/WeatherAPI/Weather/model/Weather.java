package com.WeatherAPI.Weather.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
}

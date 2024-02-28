package com.WeatherAPI.Weather.dto;

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
}

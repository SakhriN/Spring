package net.example.exo_2_apis.controller;

import net.example.exo_2_apis.model.WeatherData;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather-api")
public class WeatherController {

    @GetMapping("/getWeather")
    public WeatherData getWeather() {
        WeatherData weatherData = new WeatherData();
        weatherData.setTemperature("25°C");
        weatherData.setDescription("Sunny");
        return weatherData;
    }
}


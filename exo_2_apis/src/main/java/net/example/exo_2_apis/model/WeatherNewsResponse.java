package net.example.exo_2_apis.model;

import lombok.*;

@Data
public class WeatherNewsResponse {
    private WeatherData weatherData;
    private NewsData newsData;

    public WeatherNewsResponse(WeatherData weatherData, NewsData newsData) {
        this.weatherData = weatherData;
        this.newsData = newsData;
    }

    public WeatherNewsResponse() {
    }
}
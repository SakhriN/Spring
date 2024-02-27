package net.example.exo_2_apis.service;

import net.example.exo_2_apis.model.NewsData;
import net.example.exo_2_apis.model.WeatherData;
import net.example.exo_2_apis.model.WeatherNewsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class WeatherNewsService {

    private final WebClient weatherWebClient;
    private final WebClient newsWebClient;

    @Autowired
    public WeatherNewsService(WebClient.Builder webClientBuilder) {
        this.weatherWebClient = webClientBuilder.baseUrl("http://localhost:8080/weather-api").build();
        this.newsWebClient = webClientBuilder.baseUrl("http://localhost:8080/news-api").build();
    }

    public Mono<WeatherNewsResponse> getWeatherAndNews() {
        Mono<WeatherData> weatherDataMono = weatherWebClient.get()
                .uri("/getWeather")
                .retrieve()
                .bodyToMono(WeatherData.class);

        Mono<NewsData> newsDataMono = newsWebClient.get()
                .uri("/getNews")
                .retrieve()
                .bodyToMono(NewsData.class);

        return Mono.zip(weatherDataMono, newsDataMono)
                .map(tuple -> new WeatherNewsResponse(tuple.getT1(), tuple.getT2()));
    }
}

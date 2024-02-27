package net.example.exo_2_apis.controller;

import net.example.exo_2_apis.model.NewsData;
import net.example.exo_2_apis.model.WeatherData;
import net.example.exo_2_apis.model.WeatherNewsResponse;
import net.example.exo_2_apis.service.WeatherNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
@RequestMapping("/api/weather-news")
public class WeatherNewsController {

    private WebClient webClient;

    public WeatherNewsController() {
        webClient = WebClient.builder().baseUrl("http://localhost:8080").build();
    }

    @GetMapping
    public Flux<String> get() {
        return this.webClient.get().uri("/news")
                .retrieve()
                .bodyToFlux(String.class).delayElements(Duration.ofSeconds(2));
    }

    @GetMapping
    @RequestMapping("/zip")
    public Flux<Object> getZip() {
        Flux<String> flux1 = this.webClient.get().uri("/news-api/getNews")
                .retrieve()
                .bodyToFlux(String.class).delayElements(Duration.ofSeconds(2));

        Flux<String> flux2 = this.webClient.get().uri("weather-api/getWeather")
                .retrieve()
                .bodyToFlux(String.class);
        return Flux.zip(flux1, flux2).map(t -> t.getT1() + t.getT2());
    }
}



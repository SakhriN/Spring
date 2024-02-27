package net.example.exo_2_apis.controller;

import net.example.exo_2_apis.model.NewsData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/news-api")
public class NewsController {

    @GetMapping("/getNews")
    public NewsData getNews() {
        NewsData newsData = new NewsData();
        newsData.setHeadlines(Arrays.asList("Breaking News 1", "Breaking News 2", "Breaking News 3"));
        return newsData;
    }
}


package com.github.mullerdaniil.trinculo.engine.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

@Component
public class WeatherService {
    // TODO: remake to return int and add throws
    public String getCurrentWeather() {
        try {
            var doc = Jsoup.connect("https://rp5.ru/Погода_в_Санкт-Петербурге").get();
            return doc.select("#ArchTemp").select(".t_0").text().split("\\s+")[0];
        } catch (Exception e) {
            e.printStackTrace();
            return "xxx";
        }
    }
}

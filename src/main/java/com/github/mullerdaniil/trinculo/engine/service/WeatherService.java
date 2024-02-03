package com.github.mullerdaniil.trinculo.engine.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class WeatherService {
    // TODO: remake to return int and add throws
    public String getCurrentWeather() {
        try {
            var doc = Jsoup.connect("https://www.gismeteo.ru/weather-sankt-peterburg-4079/").get();
            var tabContentNow = selectSingleElementContainingText(doc.select(".tab-content"), "Сейчас");
            var weatherElement = tabContentNow.child(2).child(0).child(0);
            var sign = weatherElement.childNode(0).childNode(0).toString();
            var value = weatherElement.childNode(1).toString();

            if (value.length() == 1) {
                value = "0" + value;
            }

            var result = sign + value;

            if (result.length() != 3) {
                return "---";
            }

            return result;
        } catch (IOException e) {
            return "xxx";
        }
    }

    private Element selectSingleElementContainingText(Elements elements, String text) {
        return elements.stream()
                .filter(element -> !element.getElementsContainingText(text).isEmpty())
                .findFirst()
                .orElse(null);
    }
}

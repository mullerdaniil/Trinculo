package com.github.mullerdaniil.trinculo.ui.scheduling;

import com.github.mullerdaniil.trinculo.engine.service.WeatherService;
import com.github.mullerdaniil.trinculo.ui.element.TextDisplay;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SchedulingConfiguration {
    private final WeatherService weatherService;
    private final TextDisplay weatherDisplay;

    @Scheduled(fixedRate = 10000)
    public void updateWeather() {
        weatherDisplay.setText(weatherService.getCurrentWeather());
    }
}

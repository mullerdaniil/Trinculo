package com.github.mullerdaniil.trinculo.ui.scheduling;

import com.github.mullerdaniil.trinculo.engine.service.WeatherService;
import com.github.mullerdaniil.trinculo.ui.element.base.TextDisplay;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

import static com.github.mullerdaniil.trinculo.ui.utils.ConversionUtils.*;

@RequiredArgsConstructor
@Component
public class SchedulingConfiguration {
    private final WeatherService weatherService;
    private final TextDisplay weatherDisplay;
    private final TextDisplay currentDateDisplay;
    private final TextDisplay currentDayOfWeekDisplay;
    private final TextDisplay currentTimeDisplay;

    @Scheduled(cron = "0 * * * * *")
    public void updateWeather() {
        weatherDisplay.setText(weatherService.getCurrentWeather());
    }

    @Scheduled(cron = "* * 0 * * *")
    public void updateCurrentDateAndDayOfWeek() {
        currentDateDisplay.setText(convertTimestampToDateString(LocalDateTime.now()));
        currentDayOfWeekDisplay.setText(convertTimestampToDayOfWeekTwoLettersCodeString(LocalDateTime.now()));
    }

    @Scheduled(cron = "* * * * * *")
    public void updateCurrentTime() {
        currentTimeDisplay.setText(convertTimestampToTimeString(LocalDateTime.now()));
    }
}

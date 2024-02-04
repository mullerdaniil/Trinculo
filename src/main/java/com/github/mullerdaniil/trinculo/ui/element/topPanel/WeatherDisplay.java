package com.github.mullerdaniil.trinculo.ui.element.topPanel;

import com.github.mullerdaniil.trinculo.engine.service.WeatherService;
import com.github.mullerdaniil.trinculo.ui.animation.base.AnimationContext;
import com.github.mullerdaniil.trinculo.ui.element.base.TextDisplay;
import com.github.mullerdaniil.trinculo.ui.font.Font;
import com.github.mullerdaniil.trinculo.ui.font.FontDrawingContext;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import static com.github.mullerdaniil.trinculo.ui.utils.LocationConstants.WEATHER_DISPLAY_LOCATION;
import static com.github.mullerdaniil.trinculo.ui.utils.SizeConstants.WEATHER_DISPLAY_SIZE;

@Component
public class WeatherDisplay extends TextDisplay {
    private final WeatherService weatherService;

    public WeatherDisplay(FontDrawingContext fontDrawingContext,
                          AnimationContext animationContext,
                          Font digitalFont,
                          WeatherService weatherService) {
        super(
                fontDrawingContext,
                WEATHER_DISPLAY_LOCATION,
                animationContext,
                digitalFont,
                WEATHER_DISPLAY_SIZE,
                fontDrawingContext.getColorScheme().getTextLabelTextColor(),
                fontDrawingContext.getColorScheme().getTextLabelBackgroundColor()
        );
        this.weatherService = weatherService;
    }

    @PostConstruct
    public void init() {
        setText(weatherService.getCurrentWeather());
    }
}

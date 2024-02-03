package com.github.mullerdaniil.trinculo.ui.configuration;

import com.github.mullerdaniil.trinculo.ui.animation.base.AnimationContext;
import com.github.mullerdaniil.trinculo.ui.color.ColorScheme;
import com.github.mullerdaniil.trinculo.ui.element.TextDisplay;
import com.github.mullerdaniil.trinculo.ui.element.TextLabel;
import com.github.mullerdaniil.trinculo.ui.font.Font;
import com.github.mullerdaniil.trinculo.ui.graphics.FontDrawer;
import com.github.mullerdaniil.trinculo.ui.graphics.Location;
import com.github.mullerdaniil.trinculo.ui.graphics.Scaler;
import com.github.mullerdaniil.trinculo.ui.graphics.Size;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.github.mullerdaniil.trinculo.ui.utils.Constants.WINDOW_NAME;

@Configuration
public class ElementConfiguration {
    @Bean
    public TextLabel applicationNameLabel(Scaler scaler,
                                          FontDrawer fontDrawer,
                                          ColorScheme colorScheme,
                                          Font mainFont) {
        return new TextLabel(
                scaler,
                new Location(4, 4),
                fontDrawer,
                colorScheme.getAppNameLabelColor(),
                mainFont,
                WINDOW_NAME
        );
    }

    @Bean
    public TextDisplay weatherDisplay(Scaler scaler,
                                      AnimationContext animationContext,
                                      FontDrawer fontDrawer,
                                      ColorScheme colorScheme,
                                      Font digitalFont) {
        return new TextDisplay(
                scaler,
                new Location(64, 4),
                animationContext,
                fontDrawer,
                colorScheme,
                digitalFont,
                new Size(13, 7),
                colorScheme.getTextLabelTextColor(),
                colorScheme.getTextLabelBackgroundColor()
        );
    }
}

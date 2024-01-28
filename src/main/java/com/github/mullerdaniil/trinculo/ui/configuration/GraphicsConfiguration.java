package com.github.mullerdaniil.trinculo.ui.configuration;

import com.github.mullerdaniil.trinculo.ui.color.AlphaColorScheme;
import com.github.mullerdaniil.trinculo.ui.color.ColorScheme;
import com.github.mullerdaniil.trinculo.ui.graphics.Scaler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphicsConfiguration {
    @Bean
    public Scaler graphicsScaler() {
        return new Scaler(5);
    }
}

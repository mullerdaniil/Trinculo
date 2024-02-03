package com.github.mullerdaniil.trinculo.ui.configuration;

import com.github.mullerdaniil.trinculo.ui.graphics.Scaler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.github.mullerdaniil.trinculo.ui.utils.Constants.SCALE;

@Configuration
public class GraphicsConfiguration {
    @Bean
    public Scaler scaler() {
        return new Scaler(SCALE);
    }
}

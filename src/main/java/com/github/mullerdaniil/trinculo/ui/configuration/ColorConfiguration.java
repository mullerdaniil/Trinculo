package com.github.mullerdaniil.trinculo.ui.configuration;

import com.github.mullerdaniil.trinculo.ui.color.AlphaColorScheme;
import com.github.mullerdaniil.trinculo.ui.color.BetaColorScheme;
import com.github.mullerdaniil.trinculo.ui.color.ColorScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ColorConfiguration {
    @Bean
    public ColorScheme colorScheme() {
        return new BetaColorScheme();
    }
}

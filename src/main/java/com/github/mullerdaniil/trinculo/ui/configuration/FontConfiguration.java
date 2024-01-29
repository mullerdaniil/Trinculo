package com.github.mullerdaniil.trinculo.ui.configuration;

import com.github.mullerdaniil.trinculo.ui.font.Font;
import com.github.mullerdaniil.trinculo.ui.font.FontLoader;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.github.mullerdaniil.trinculo.utils.PathProperties.FONTS_DIRECTORY_PATH;

@RequiredArgsConstructor
@Configuration
public class FontConfiguration {
    private final FontLoader fontLoader;
    @Bean
    public Font mainFont() {
        return fontLoader.loadFont(FONTS_DIRECTORY_PATH.resolve("main.json"));
    }
    @Bean
    public Font digitalFont() {
        return fontLoader.loadFont(FONTS_DIRECTORY_PATH.resolve("digital.json"));
    }
}

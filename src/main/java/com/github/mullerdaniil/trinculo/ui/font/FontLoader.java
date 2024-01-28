package com.github.mullerdaniil.trinculo.ui.font;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Path;

@RequiredArgsConstructor
@Component
public class FontLoader {
    private final ObjectMapper objectMapper;

    public Font loadFont(Path fontFilePath) {
        try {
            return objectMapper.readValue(fontFilePath.toFile(), Font.class);
        } catch (IOException e) {
            throw new FontLoadException("Can't load font.", e);
        }
    }
}

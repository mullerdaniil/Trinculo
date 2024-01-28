package com.github.mullerdaniil.trinculo.engine;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.mullerdaniil.trinculo.engine.exception.DataInitializerException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static com.github.mullerdaniil.trinculo.utils.PathProperties.TIMESTAMPS_DATA_FILE_PATH;
import static com.github.mullerdaniil.trinculo.utils.PathProperties.TRACKS_DATA_FILE_PATH;

@RequiredArgsConstructor
@Component
public class DataInitializer {
    private final ObjectMapper objectMapper;

    public void initializeData() {
        try {
            initializeFile(TRACKS_DATA_FILE_PATH);
            initializeFile(TIMESTAMPS_DATA_FILE_PATH);

        } catch (IOException e) {
            throw new DataInitializerException("Can't initialize data.", e);
        }
    }

    private void initializeFile(Path path) throws IOException {
        if (Files.notExists(path)) {
            Files.createFile(path);
            objectMapper.writeValue(path.toFile(), new ArrayList<>());
        }
    }
}

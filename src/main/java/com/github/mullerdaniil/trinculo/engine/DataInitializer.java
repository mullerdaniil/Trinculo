package com.github.mullerdaniil.trinculo.engine;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.mullerdaniil.trinculo.engine.exception.DataInitializerException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static com.github.mullerdaniil.trinculo.utils.PathProperties.*;

@RequiredArgsConstructor
@Component
public class DataInitializer {
    private final ObjectMapper objectMapper;

    public void initializeData() {
        try {
            initializeDirectory(DATA_DIRECTORY_PATH);
            initializeEntitiesFile(TRACKS_DATA_FILE_PATH);
            initializeEntitiesFile(TIMESTAMPS_DATA_FILE_PATH);

        } catch (IOException e) {
            throw new DataInitializerException("Can't initialize data.", e);
        }
    }

    private void initializeDirectory(Path path) throws IOException {
        if (Files.notExists(path)) {
            Files.createDirectory(path);
        }
    }

    private void initializeEntitiesFile(Path path) throws IOException {
        if (Files.notExists(path)) {
            Files.createFile(path);
            objectMapper.writeValue(path.toFile(), new ArrayList<>());
        }
    }
}

package com.github.mullerdaniil.trinculo.utils;

import java.nio.file.Path;

public class PathProperties {
    public static final Path DATA_DIRECTORY_PATH = Path.of("data");
    public static final Path TRACKS_DATA_FILE_PATH = DATA_DIRECTORY_PATH.resolve("tracks.json");
    public static final Path TIMESTAMPS_DATA_FILE_PATH = DATA_DIRECTORY_PATH.resolve("timestamps.json");
    public static final Path FONTS_DIRECTORY_PATH = Path.of("res", "fonts");
}

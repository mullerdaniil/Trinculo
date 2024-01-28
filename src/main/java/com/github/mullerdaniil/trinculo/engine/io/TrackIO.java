package com.github.mullerdaniil.trinculo.engine.io;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.mullerdaniil.trinculo.engine.entity.Track;
import org.springframework.stereotype.Component;

import java.nio.file.Path;

import static com.github.mullerdaniil.trinculo.utils.PathProperties.TRACKS_DATA_FILE_PATH;

@Component
public class TrackIO extends EntityIO<Track> {
    @Override
    protected Path getEntitiesFilePath() {
        return TRACKS_DATA_FILE_PATH;
    }

    @Override
    protected Class<Track> getEntityClass() {
        return Track.class;
    }
}

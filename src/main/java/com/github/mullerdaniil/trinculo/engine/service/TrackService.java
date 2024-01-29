package com.github.mullerdaniil.trinculo.engine.service;

import com.github.mullerdaniil.trinculo.engine.dto.CreateTrackDTO;
import com.github.mullerdaniil.trinculo.engine.io.TrackIO;
import com.github.mullerdaniil.trinculo.engine.mapper.CreateTrackDTOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class TrackService {
    private TrackIO trackIO;
    private CreateTrackDTOMapper createTrackDTOMapper;

    public void create(CreateTrackDTO createTrackDTO) {
        // TODO: impl
        var tracks = trackIO.read();
        tracks.add(createTrackDTO.index(), createTrackDTOMapper.map(createTrackDTO));
        trackIO.write(tracks);
    }
}

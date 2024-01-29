package com.github.mullerdaniil.trinculo.engine.mapper;

import com.github.mullerdaniil.trinculo.engine.dto.CreateTrackDTO;
import com.github.mullerdaniil.trinculo.engine.entity.Track;
import org.springframework.stereotype.Component;

@Component
public class CreateTrackDTOMapper implements Mapper<CreateTrackDTO, Track> {
    @Override
    public Track map(CreateTrackDTO object) {
        return null;
    }
}

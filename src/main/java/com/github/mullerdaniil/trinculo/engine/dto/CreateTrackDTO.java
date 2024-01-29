package com.github.mullerdaniil.trinculo.engine.dto;

import java.time.LocalDateTime;

public record CreateTrackDTO(String name,
                             int index,
                             LocalDateTime deadline) {
}

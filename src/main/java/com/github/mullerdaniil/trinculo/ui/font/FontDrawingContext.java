package com.github.mullerdaniil.trinculo.ui.font;

import com.github.mullerdaniil.trinculo.ui.color.ColorScheme;
import com.github.mullerdaniil.trinculo.ui.graphics.Scaler;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Getter
@RequiredArgsConstructor
@Component
public class FontDrawingContext {
    private final Scaler scaler;
    private final FontDrawer fontDrawer;
    private final ColorScheme colorScheme;
}

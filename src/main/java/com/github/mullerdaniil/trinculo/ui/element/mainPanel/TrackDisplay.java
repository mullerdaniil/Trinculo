package com.github.mullerdaniil.trinculo.ui.element.mainPanel;

import com.github.mullerdaniil.trinculo.ui.animation.base.AnimationContext;
import com.github.mullerdaniil.trinculo.ui.element.base.EditableTextDisplay;
import com.github.mullerdaniil.trinculo.ui.font.Font;
import com.github.mullerdaniil.trinculo.ui.font.FontDrawingContext;
import org.springframework.stereotype.Component;

import static com.github.mullerdaniil.trinculo.ui.utils.Constants.FULL_WINDOW_DISPLAY_SYMBOLS_COUNT_LIMIT;
import static com.github.mullerdaniil.trinculo.ui.utils.LocationConstants.TRACK_DISPLAY_LOCATION;
import static com.github.mullerdaniil.trinculo.ui.utils.SizeConstants.TRACK_DISPLAY_SIZE;

@Component
public class TrackDisplay extends EditableTextDisplay {
    public TrackDisplay(FontDrawingContext fontDrawingContext,
                        AnimationContext animationContext,
                        Font mainFont) {
        super(
                fontDrawingContext,
                TRACK_DISPLAY_LOCATION,
                animationContext,
                mainFont,
                TRACK_DISPLAY_SIZE,
                fontDrawingContext.getColorScheme().getTextLabelTextColor(),
                fontDrawingContext.getColorScheme().getTextLabelBackgroundColor(),
                fontDrawingContext.getColorScheme().getEnabledLineStartIndicatorColor(),
                fontDrawingContext.getColorScheme().getDisabledLineStartIndicatorColor(),
                FULL_WINDOW_DISPLAY_SYMBOLS_COUNT_LIMIT
        );
    }
}

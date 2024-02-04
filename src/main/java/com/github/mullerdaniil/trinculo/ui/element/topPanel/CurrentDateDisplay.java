package com.github.mullerdaniil.trinculo.ui.element.topPanel;

import com.github.mullerdaniil.trinculo.ui.animation.base.AnimationContext;
import com.github.mullerdaniil.trinculo.ui.element.base.TextDisplay;
import com.github.mullerdaniil.trinculo.ui.font.Font;
import com.github.mullerdaniil.trinculo.ui.font.FontDrawingContext;
import com.github.mullerdaniil.trinculo.ui.utils.ConversionUtils;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

import static com.github.mullerdaniil.trinculo.ui.utils.ConversionUtils.convertTimestampToDateString;
import static com.github.mullerdaniil.trinculo.ui.utils.LocationConstants.CURRENT_DATE_DISPLAY_LOCATION;
import static com.github.mullerdaniil.trinculo.ui.utils.SizeConstants.CURRENT_DATE_DISPLAY_SIZE;

@Component
public class CurrentDateDisplay extends TextDisplay {
    public CurrentDateDisplay(FontDrawingContext fontDrawingContext,
                              AnimationContext animationContext,
                              Font digitalFont) {
        super(
                fontDrawingContext,
                CURRENT_DATE_DISPLAY_LOCATION,
                animationContext,
                digitalFont,
                CURRENT_DATE_DISPLAY_SIZE,
                fontDrawingContext.getColorScheme().getTextLabelTextColor(),
                fontDrawingContext.getColorScheme().getTextLabelBackgroundColor()
        );
    }

    @PostConstruct
    public void init() {
        setText(convertTimestampToDateString(LocalDateTime.now()));
    }
}

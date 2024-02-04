package com.github.mullerdaniil.trinculo.ui.element.topPanel;

import com.github.mullerdaniil.trinculo.ui.animation.base.AnimationContext;
import com.github.mullerdaniil.trinculo.ui.element.base.TextDisplay;
import com.github.mullerdaniil.trinculo.ui.font.Font;
import com.github.mullerdaniil.trinculo.ui.font.FontDrawingContext;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

import static com.github.mullerdaniil.trinculo.ui.utils.ConversionUtils.convertTimestampToDayOfWeekTwoLettersCodeString;
import static com.github.mullerdaniil.trinculo.ui.utils.LocationConstants.CURRENT_DAY_OF_WEEK_DISPLAY_LOCATION;
import static com.github.mullerdaniil.trinculo.ui.utils.SizeConstants.CURRENT_DAY_OF_WEEK_DISPLAY_SIZE;

@Component
public class CurrentDayOfWeekDisplay extends TextDisplay {
    public CurrentDayOfWeekDisplay(FontDrawingContext fontDrawingContext,
                                   AnimationContext animationContext,
                                   Font mainFont) {
        super(
                fontDrawingContext,
                CURRENT_DAY_OF_WEEK_DISPLAY_LOCATION,
                animationContext,
                mainFont,
                CURRENT_DAY_OF_WEEK_DISPLAY_SIZE,
                fontDrawingContext.getColorScheme().getTextLabelTextColor(),
                fontDrawingContext.getColorScheme().getTextLabelBackgroundColor()
        );
    }

    @PostConstruct
    public void init() {
        setText(convertTimestampToDayOfWeekTwoLettersCodeString(LocalDateTime.now()));
    }
}

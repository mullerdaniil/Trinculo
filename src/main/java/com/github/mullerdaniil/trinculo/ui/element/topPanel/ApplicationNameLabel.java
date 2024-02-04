package com.github.mullerdaniil.trinculo.ui.element.topPanel;

import com.github.mullerdaniil.trinculo.ui.color.ColorScheme;
import com.github.mullerdaniil.trinculo.ui.element.base.TextLabel;
import com.github.mullerdaniil.trinculo.ui.font.Font;
import com.github.mullerdaniil.trinculo.ui.font.FontDrawer;
import com.github.mullerdaniil.trinculo.ui.graphics.Scaler;
import org.springframework.stereotype.Component;

import static com.github.mullerdaniil.trinculo.ui.utils.Constants.WINDOW_NAME;
import static com.github.mullerdaniil.trinculo.ui.utils.LocationConstants.APPLICATION_NAME_TEXT_LABEL_LOCATION;

@Component
public class ApplicationNameLabel extends TextLabel {
    public ApplicationNameLabel(Scaler scaler, FontDrawer fontDrawer, Font mainFont, ColorScheme colorScheme) {
        super(scaler, APPLICATION_NAME_TEXT_LABEL_LOCATION, fontDrawer, colorScheme.getAppNameLabelColor(), mainFont, WINDOW_NAME);
    }
}

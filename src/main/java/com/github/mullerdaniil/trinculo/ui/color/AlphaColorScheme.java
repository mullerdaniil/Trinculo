package com.github.mullerdaniil.trinculo.ui.color;

import java.awt.*;

public class AlphaColorScheme implements ColorScheme {
    @Override
    public Color getWindowBackgroundColor() {
        return new Color(32, 32, 32);
    }

    @Override
    public Color getAppNameLabelColor() {
        return new Color(128, 128, 128);
    }

    @Override
    public Color getTextLabelBackgroundColor() {
        return new Color(64, 0, 0);
    }

    @Override
    public Color getTextLabelTextColor() {
        return new Color(192, 0, 0);
    }

    @Override
    public Color getTextLabelTextFlashColor() {
        return new Color(255, 64, 64);
    }

    @Override
    public Color getEnabledLineStartIndicatorColor() {
        return new Color(224, 224, 0);
    }

    @Override
    public Color getDisabledLineStartIndicatorColor() {
        return new Color(100, 100, 0);
    }

    @Override
    public Color getDisplayCursorColor() {
        return new Color(160, 160, 0);
    }
}

package com.github.mullerdaniil.trinculo.ui.color;

import java.awt.*;

public class BetaColorScheme implements ColorScheme {
    @Override
    public Color getWindowBackgroundColor() {
        return new Color(32, 32, 32);
    }

    @Override
    public Color getAppNameLabelColor() {
        return new Color(140, 160, 140);
    }

    @Override
    public Color getTextLabelBackgroundColor() {
        return new Color(0, 48, 0);
    }

    @Override
    public Color getTextLabelTextColor() {
        return new Color(0, 140, 0);
    }

    @Override
    public Color getTextLabelTextFlashColor() {
        return new Color(96, 255, 64);
    }

    @Override
    public Color getEnabledLineStartIndicatorColor() {
        return new Color(128, 224, 0);
    }

    @Override
    public Color getDisabledLineStartIndicatorColor() {
        return new Color(100, 100, 0);
    }

    @Override
    public Color getDisplayCursorColor() {
        return new Color(160, 220, 160);
    }
}

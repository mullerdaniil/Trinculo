package com.github.mullerdaniil.trinculo.ui.color;

import java.awt.*;

import static com.github.mullerdaniil.trinculo.ui.utils.Constants.COLOR_COMPONENT_MAX_VALUE;
import static com.github.mullerdaniil.trinculo.ui.utils.Constants.COLOR_COMPONENT_MIN_VALUE;

public class ColorUtils {
    public static Color transformColor(Color colorFrom,
                                       Color colorTo,
                                       double degree) {
        if (degree < 0 || degree > 1) {
            throw new IllegalArgumentException("Degree must be between 0 and 1. Given parameter is %s".formatted(degree));
        }

        int red = transformComponent(colorFrom.getRed(), colorTo.getRed(), degree);
        int green = transformComponent(colorFrom.getGreen(), colorTo.getGreen(), degree);
        int blue = transformComponent(colorFrom.getBlue(), colorTo.getBlue(), degree);

        return new Color(red, green, blue);
    }

    private static int transformComponent(int colorFromComponentValue, int colorToComponentValue, double degree) {
        int newComponentValue = (int) (colorFromComponentValue + (double) (colorToComponentValue - colorFromComponentValue) * degree);
        if (newComponentValue < COLOR_COMPONENT_MIN_VALUE) {
            return COLOR_COMPONENT_MIN_VALUE;
        }

        return Math.min(newComponentValue, COLOR_COMPONENT_MAX_VALUE);
    }
}

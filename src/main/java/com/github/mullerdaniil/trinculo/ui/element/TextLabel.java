package com.github.mullerdaniil.trinculo.ui.element;

import com.github.mullerdaniil.trinculo.ui.element.base.Element;
import com.github.mullerdaniil.trinculo.ui.font.Font;
import com.github.mullerdaniil.trinculo.ui.graphics.FontDrawer;
import com.github.mullerdaniil.trinculo.ui.graphics.Location;
import com.github.mullerdaniil.trinculo.ui.graphics.Scaler;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

public class TextLabel extends Element {
    private final FontDrawer fontDrawer;
    private final Font font;

    @Getter
    @Setter
    private Color textColor;

    @Getter
    @Setter
    private String text;

    public TextLabel(Scaler scaler, Location location, FontDrawer fontDrawer, Color textColor, Font font, String text) {
        super(scaler, location);
        this.fontDrawer = fontDrawer;
        this.textColor = textColor;
        this.font = font;
        this.text = text;
    }

    @Override
    public void draw(Graphics g) {
        fontDrawer.drawString(text, font, location.x() + 1, location.y() + 1, textColor, g);
    }

    @Override
    public void onKeyPressed(int keyCode) {

    }

    @Override
    public void onKeyReleased(int keyCode) {

    }
}

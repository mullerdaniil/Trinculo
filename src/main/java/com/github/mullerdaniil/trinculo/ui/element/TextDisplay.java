package com.github.mullerdaniil.trinculo.ui.element;

import com.github.mullerdaniil.trinculo.ui.animation.TextDisplaySetTextAnimation;
import com.github.mullerdaniil.trinculo.ui.animation.base.AnimationContext;
import com.github.mullerdaniil.trinculo.ui.color.ColorScheme;
import com.github.mullerdaniil.trinculo.ui.element.base.Element;
import com.github.mullerdaniil.trinculo.ui.font.Font;
import com.github.mullerdaniil.trinculo.ui.graphics.FontDrawer;
import com.github.mullerdaniil.trinculo.ui.graphics.Location;
import com.github.mullerdaniil.trinculo.ui.graphics.Scaler;
import com.github.mullerdaniil.trinculo.ui.graphics.Size;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

import static com.github.mullerdaniil.trinculo.ui.utils.Constants.ANIMATION_DURATION;

public class TextDisplay extends Element {
    private final AnimationContext animationContext;
    private final FontDrawer fontDrawer;
    private final ColorScheme colorScheme;
    private final Font font;
    private final Size size;

    @Getter
    @Setter
    private Color textColor;

    @Getter
    @Setter
    private Color backgroundColor;

    private String text = "";

    public TextDisplay(Scaler scaler,
                       Location location,
                       AnimationContext animationContext,
                       FontDrawer fontDrawer,
                       ColorScheme colorScheme,
                       Font font,
                       Size size,
                       Color textColor,
                       Color backgroundColor) {
        super(scaler, location);
        this.animationContext = animationContext;
        this.fontDrawer = fontDrawer;
        this.colorScheme = colorScheme;
        this.font = font;
        this.size = size;
        this.textColor = textColor;
        this.backgroundColor = backgroundColor;
    }

    @Override
    public void draw(Graphics g) {
        scaler.drawRectangle(location.x(), location.y(), size.width(), size.height(), backgroundColor, g);
        fontDrawer.drawString(text, font, location.x() + 1, location.y() + 1, textColor, g);
    }

    @Override
    public void onKeyPressed(int keyCode) {

    }

    @Override
    public void onKeyReleased(int keyCode) {

    }

    public void setText(String text) {
        this.text = text;
        animationContext.launch(new TextDisplaySetTextAnimation(this, colorScheme, ANIMATION_DURATION));
    }
}

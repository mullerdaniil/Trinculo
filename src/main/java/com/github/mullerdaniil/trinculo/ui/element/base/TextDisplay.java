package com.github.mullerdaniil.trinculo.ui.element.base;

import com.github.mullerdaniil.trinculo.ui.animation.TextDisplaySetTextAnimation;
import com.github.mullerdaniil.trinculo.ui.animation.base.AnimationContext;
import com.github.mullerdaniil.trinculo.ui.color.ColorScheme;
import com.github.mullerdaniil.trinculo.ui.font.Font;
import com.github.mullerdaniil.trinculo.ui.font.FontDrawer;
import com.github.mullerdaniil.trinculo.ui.font.FontDrawingContext;
import com.github.mullerdaniil.trinculo.ui.graphics.Location;
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

    public TextDisplay(FontDrawingContext fontDrawingContext,
                       Location location,
                       AnimationContext animationContext,
                       Font font,
                       Size size,
                       Color textColor,
                       Color backgroundColor) {
        super(fontDrawingContext.getScaler(), location);
        this.animationContext = animationContext;
        this.fontDrawer = fontDrawingContext.getFontDrawer();
        this.colorScheme = fontDrawingContext.getColorScheme();
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

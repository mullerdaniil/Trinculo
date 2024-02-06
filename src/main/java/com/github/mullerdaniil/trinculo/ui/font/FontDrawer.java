package com.github.mullerdaniil.trinculo.ui.font;

import com.github.mullerdaniil.trinculo.ui.graphics.Scaler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.awt.*;

@RequiredArgsConstructor
@Component
public class FontDrawer {
    private final Scaler scaler;

    public void drawString(String text, Font font, int x, int y, Color color, Graphics g) {
        for (char character : text.toCharArray()) {
            var glyph = font.getGlyph(character);
            drawGlyph(glyph, x, y, color, g);

            x += (glyph != null ? glyph.width() : font.getEmptyGlyphWidth()) + 1;
        }
    }

    public void drawGlyph(Glyph glyph, int x, int y, Color color, Graphics g) {
        if (glyph == null) {
            return;
        }

        g.setColor(color);
        for (int iy = 0; iy < glyph.height(); iy++) {
            for (int ix = 0; ix < glyph.width(); ix++) {
                if (glyph.getDrawPatternDot(ix, iy)) {
                    scaler.drawDot(x + ix, y + iy, g);
                }
            }
        }
    }
}

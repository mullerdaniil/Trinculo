package com.github.mullerdaniil.trinculo.ui.graphics;

import lombok.RequiredArgsConstructor;

import java.awt.*;

@RequiredArgsConstructor
public class Scaler {
    private final Integer scale;

    public int scale(int value) {
        return value * scale;
    }

    public void drawDot(int x, int y, Color color, Graphics g) {
        drawSquare(x, y, 1, color, g);
    }

    public void drawDot(int x, int y, Graphics g) {
        drawSquare(x, y, 1, g);
    }

    public void drawSquare(int x, int y, int size, Color color, Graphics g) {
        drawRectangle(x, y, size, size, color, g);
    }

    public void drawSquare(int x, int y, int size, Graphics g) {
        drawRectangle(x, y, size, size, g);
    }

    public void drawRectangle(int x, int y, int width, int height, Color color, Graphics g) {
        g.setColor(color);
        drawRectangle(x, y, width, height, g);
    }

    public void drawRectangle(int x, int y, int width, int height, Graphics g) {
        g.fillRect(x * scale, y * scale, width * scale, height * scale);
    }
}

package com.github.mullerdaniil.trinculo.ui.font;


public record Glyph(int height, int width, boolean[][] drawPattern) {
    public boolean getDrawPatternDot(int x, int y) {
        return drawPattern[y][x];
    }
}

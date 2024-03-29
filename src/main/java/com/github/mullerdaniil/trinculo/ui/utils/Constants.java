package com.github.mullerdaniil.trinculo.ui.utils;

import java.util.Set;

public class Constants {
    public static final String WINDOW_NAME = "TRINCULO";
    public static final int WINDOW_WIDTH_RPX = 160;
    public static final int WINDOW_HEIGHT_RPX = 120;
    public static final int WINDOW_WIDTH_MARGIN_PX = 16;
    public static final int WINDOW_HEIGHT_MARGIN_PX = 38;
    public static final int TIMER_DELAY = 10;
    public static final int SCALE = 6;
    public static final Set<Character> ENCODED_GLYPH_NON_ACTIVE_CHAR_SET = Set.of(' ', '.');
    public static final Set<Character> ENCODED_GLYPH_SKIPPED_CHAR_SET = Set.of('|');
    public static final int COLOR_COMPONENT_MIN_VALUE = 0;
    public static final int COLOR_COMPONENT_MAX_VALUE = 255;
    public static final long ANIMATION_DURATION = 40;
    public static final int FULL_WINDOW_DISPLAY_SYMBOLS_COUNT_LIMIT = 25;
    public static final int DISPLAY_SYMBOL_DISTANCE = 6;
}

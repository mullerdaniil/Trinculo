package com.github.mullerdaniil.trinculo.ui.element.base;

import com.github.mullerdaniil.trinculo.ui.animation.EditableTextDisplaySetSymbolColorAnimation;
import com.github.mullerdaniil.trinculo.ui.animation.base.AnimationContext;
import com.github.mullerdaniil.trinculo.ui.font.Font;
import com.github.mullerdaniil.trinculo.ui.font.FontDrawingContext;
import com.github.mullerdaniil.trinculo.ui.graphics.Location;
import com.github.mullerdaniil.trinculo.ui.graphics.Size;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.awt.*;
import java.awt.event.KeyEvent;

import static com.github.mullerdaniil.trinculo.ui.utils.Constants.*;
import static com.github.mullerdaniil.trinculo.ui.utils.KeyUtils.getSymbolByKeyCode;

@EnableScheduling
public class EditableTextDisplay extends TextDisplay {
    private final Color enabledLineStartIndicatorColor;
    private final Color disabledLineStartIndicatorColor;
    private final int symbolsCountLimit;
    private final Color[] symbolColors;
    private String fullText = "";
    private String partialText = "";
    private int cursorPosition = 0;
    private int leftSymbolPosition = 0;
    private boolean isCursorEnabled = false;
    private Color indicatorColor;


    public EditableTextDisplay(FontDrawingContext fontDrawingContext,
                               Location location,
                               AnimationContext animationContext,
                               Font font,
                               Size size,
                               int symbolsCountLimit) {
        super(fontDrawingContext, location, animationContext, font, size);
        enabledLineStartIndicatorColor = fontDrawingContext.getColorScheme().getEnabledLineStartIndicatorColor();
        disabledLineStartIndicatorColor = fontDrawingContext.getColorScheme().getDisabledLineStartIndicatorColor();
        this.symbolsCountLimit = symbolsCountLimit;
        indicatorColor = enabledLineStartIndicatorColor;
        symbolColors = new Color[symbolsCountLimit];
        for (int i = 0; i < symbolsCountLimit; i++) {
            symbolColors[i] = getTextColor();
        }
    }

    @Override
    public void draw(Graphics g) {
        scaler.drawRectangle(location.x(), location.y(), 1, getSize().height(), indicatorColor, g);
        scaler.drawRectangle(location.x() + 1, location.y(), getSize().width() - 1, getSize().height(), getBackgroundColor(), g);
        for (int i = 0; i < partialText.length(); i++) {
            getFontDrawer().drawString(String.valueOf(partialText.charAt(i)), getFont(), location.x() + 2 + DISPLAY_SYMBOL_DISTANCE * i, location.y() + 1, symbolColors[i], g);
        }
        if (isCursorEnabled) {
            scaler.drawRectangle(location.x() + 1 + (cursorPosition - leftSymbolPosition) * DISPLAY_SYMBOL_DISTANCE, location.y() + 1, 1, getSize().height() - 2, getColorScheme().getDisplayCursorColor(), g);
        }
    }

    @Scheduled(fixedRate = 350)
    public void toggleCursor() {
        isCursorEnabled = !isCursorEnabled;
    }

    private void updateIndicator() {
        indicatorColor = cursorPosition == 0 ? enabledLineStartIndicatorColor : disabledLineStartIndicatorColor;
    }

    @Override
    public void onKeyPressed(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_BACK_SPACE -> deleteSymbol();
            case KeyEvent.VK_LEFT -> moveCursorLeft();
            case KeyEvent.VK_RIGHT -> moveCursorRight();
        }

        Character symbol = getSymbolByKeyCode(keyCode);
        if (symbol != null) {
            insertSymbol(symbol);
        }
    }

    public void setSymbolColor(Color color, int position) {
        if (position >= 0 && position < symbolsCountLimit) {
            symbolColors[position] = color;
        }
    }

    private void insertSymbol(char symbol) {
        fullText = fullText.substring(0, cursorPosition) + symbol + fullText.substring(cursorPosition);
        cursorPosition++;
        // TODO: impl
        if (fullText.length() > leftSymbolPosition + symbolsCountLimit) {
            leftSymbolPosition++;
        }
        updatePartialText();
        getAnimationContext().launch(new EditableTextDisplaySetSymbolColorAnimation(
                this,
                cursorPosition - leftSymbolPosition - 1,
                getColorScheme(),
                ANIMATION_DURATION
        ));
    }

    private void deleteSymbol() {
        if (fullText.length() > 0) {
            fullText = fullText.substring(0, cursorPosition - 1) + fullText.substring(cursorPosition);
            cursorPosition--;
            // TODO: impl
            updatePartialText();
        }
    }

    private void moveCursorLeft() {
        cursorPosition = Math.max(cursorPosition - 1, 0);
        // TODO: impl
        updatePartialText();
    }

    private void moveCursorRight() {
        cursorPosition = Math.min(cursorPosition + 1, fullText.length());
        // TODO: impl
        updatePartialText();
    }

    private void updatePartialText() {
//        if (cursorPosition < leftSymbolPosition) {
/*
        if (cursorPosition == fullText.length()) {
            leftSymbolPosition = fullText.length() - Math.min(fullText.length(), FULL_WINDOW_DISPLAY_SYMBOLS_COUNT_LIMIT);
        }
        if (cursorPosition < leftSymbolPosition) {
            leftSymbolPosition = cursorPosition;
        }
        if (cursorPosition >= leftSymbolPosition + symbolsCountLimit) {
            leftSymbolPosition = cursorPosition - symbolsCountLimit;
        }

*/

        partialText = fullText.substring(leftSymbolPosition, Math.min(leftSymbolPosition + symbolsCountLimit, fullText.length()));
        updateIndicator();
    }
}

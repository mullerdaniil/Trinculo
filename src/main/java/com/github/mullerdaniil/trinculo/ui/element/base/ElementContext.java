package com.github.mullerdaniil.trinculo.ui.element.base;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.List;

@RequiredArgsConstructor
@Component
public class ElementContext {
    private final List<Element> elements;

    public void draw(Graphics g) {
        for (var element : elements) {
            element.draw(g);
        }
    }

    public void onKeyPressed(int keyCode) {
        for (var element : elements) {
            element.onKeyPressed(keyCode);
        }
    }

    public void onKeyReleased(int keyCode) {
        for (var element : elements) {
            element.onKeyReleased(keyCode);
        }
    }
}

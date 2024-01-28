package com.github.mullerdaniil.trinculo.ui.element;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ElementContext {
    private final List<Element> elements;

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

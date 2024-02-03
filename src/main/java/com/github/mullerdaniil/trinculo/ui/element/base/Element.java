package com.github.mullerdaniil.trinculo.ui.element.base;

import com.github.mullerdaniil.trinculo.ui.graphics.Location;
import com.github.mullerdaniil.trinculo.ui.graphics.Scaler;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class Element implements Drawable, KeyReactive {
    protected final Scaler scaler;
    protected final Location location;
}

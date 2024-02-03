package com.github.mullerdaniil.trinculo.ui.animation.base;

import lombok.Getter;
import lombok.Setter;

public abstract class Animation {
    @Getter
    @Setter
    private boolean isAlive = true;

    public abstract void update();
}

package com.github.mullerdaniil.trinculo.ui.animation.base;

import org.springframework.stereotype.Component;

@Component
public abstract class FixedDurationAnimation extends Animation {
    protected long duration = 0;
    protected long elapsedTicks = 0;

    @Override
    public void update() {
        if (elapsedTicks >= duration) {
            setAlive(false);
            return;
        }
        updateAnimation();
        elapsedTicks++;
    }

    protected abstract void updateAnimation();
}

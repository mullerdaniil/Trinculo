package com.github.mullerdaniil.trinculo.ui.animation.base;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@EnableScheduling
@Component
public class AnimationContext {
    private final List<Animation> animations = new ArrayList<>();

    public synchronized void update() {
        for (var animation : animations) {
            if (animation.isAlive()) {
                animation.update();
            }
        }
    }

    public synchronized void launch(Animation animation) {
        animations.add(animation);
    }

    @Scheduled(fixedRate = 5_000)
    private synchronized void clearDeadAnimations() {
        animations.removeIf(animation -> !animation.isAlive());
    }
}

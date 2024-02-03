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

    public void update() {
        for (var animation : animations) {
            if (animation.isAlive()) {
                animation.update();
            }
        }
    }

    public void launch(Animation animation) {
        animations.add(animation);
    }

    @Scheduled(fixedRate = 3000)
    private void clearDeadAnimations() {
        animations.removeIf(animation -> !animation.isAlive());
    }
}

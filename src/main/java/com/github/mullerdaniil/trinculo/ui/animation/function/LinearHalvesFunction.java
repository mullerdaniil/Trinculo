package com.github.mullerdaniil.trinculo.ui.animation.function;

import org.springframework.stereotype.Component;

@Deprecated
@Component
public class LinearHalvesFunction implements Function {
    @Override
    public double evaluate(double x) {
        return x < 0.5 ? 2 * x : 2 - 2 * x;
    }
}

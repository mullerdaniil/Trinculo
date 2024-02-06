package com.github.mullerdaniil.trinculo.ui.animation.function;

@Deprecated
public class EaseInOutCubicFunction implements Function {
    @Override
    public double evaluate(double x) {
        return x < 0.5 ? 4 * x * x * x : 1 - Math.pow(-2 * x + 2, 3) / 2;
    }
}

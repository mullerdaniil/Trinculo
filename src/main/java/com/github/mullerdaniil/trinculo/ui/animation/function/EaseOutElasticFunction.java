package com.github.mullerdaniil.trinculo.ui.animation.function;

public class EaseOutElasticFunction implements Function {
    private static final double C4 = (2 * Math.PI) / 3;

    @Override
    public double evaluate(double x) {
        return x == 0
                ? 0
                : x == 1
                ? 1
                : Math.pow(2, -10 * x) * Math.sin((x * 10 - 0.75) * C4) + 1;
    }
}

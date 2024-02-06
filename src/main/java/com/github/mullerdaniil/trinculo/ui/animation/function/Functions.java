package com.github.mullerdaniil.trinculo.ui.animation.function;

public class Functions {
    public static double linearHalves(double x) {
        return x < 0.5 ? 2 * x : 2 - 2 * x;
    }
}

package com.github.mullerdaniil.trinculo.ui.utils;

import java.awt.event.KeyEvent;
import java.util.Map;

public class KeyUtils {
    private static final Map<Integer, Character> symbolsByKeyCode = Map.ofEntries(
            Map.entry(KeyEvent.VK_A, 'A'),
            Map.entry(KeyEvent.VK_B, 'B'),
            Map.entry(KeyEvent.VK_C, 'C'),
            Map.entry(KeyEvent.VK_D, 'D'),
            Map.entry(KeyEvent.VK_E, 'E'),
            Map.entry(KeyEvent.VK_F, 'F'),
            Map.entry(KeyEvent.VK_G, 'G'),
            Map.entry(KeyEvent.VK_H, 'H'),
            Map.entry(KeyEvent.VK_I, 'I'),
            Map.entry(KeyEvent.VK_J, 'J'),
            Map.entry(KeyEvent.VK_K, 'K'),
            Map.entry(KeyEvent.VK_L, 'L'),
            Map.entry(KeyEvent.VK_M, 'M'),
            Map.entry(KeyEvent.VK_N, 'N'),
            Map.entry(KeyEvent.VK_O, 'O'),
            Map.entry(KeyEvent.VK_P, 'P'),
            Map.entry(KeyEvent.VK_Q, 'Q'),
            Map.entry(KeyEvent.VK_R, 'R'),
            Map.entry(KeyEvent.VK_S, 'S'),
            Map.entry(KeyEvent.VK_T, 'T'),
            Map.entry(KeyEvent.VK_U, 'U'),
            Map.entry(KeyEvent.VK_V, 'V'),
            Map.entry(KeyEvent.VK_W, 'W'),
            Map.entry(KeyEvent.VK_X, 'X'),
            Map.entry(KeyEvent.VK_Y, 'Y'),
            Map.entry(KeyEvent.VK_Z, 'Z'),
            Map.entry(KeyEvent.VK_SPACE, ' '),
            Map.entry(KeyEvent.VK_MINUS, '-'),
            Map.entry(KeyEvent.VK_0, '0'),
            Map.entry(KeyEvent.VK_1, '1'),
            Map.entry(KeyEvent.VK_2, '2'),
            Map.entry(KeyEvent.VK_3, '3'),
            Map.entry(KeyEvent.VK_4, '4'),
            Map.entry(KeyEvent.VK_5, '5'),
            Map.entry(KeyEvent.VK_6, '6'),
            Map.entry(KeyEvent.VK_7, '7'),
            Map.entry(KeyEvent.VK_8, '8'),
            Map.entry(KeyEvent.VK_9, '9')
    );

    public static Character getSymbolByKeyCode(int keyCode) {
        return symbolsByKeyCode.get(keyCode);
    }
}

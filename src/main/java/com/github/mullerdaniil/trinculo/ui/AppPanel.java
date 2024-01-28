package com.github.mullerdaniil.trinculo.ui;

import com.github.mullerdaniil.trinculo.engine.DataInitializer;
import com.github.mullerdaniil.trinculo.ui.color.ColorScheme;
import com.github.mullerdaniil.trinculo.ui.element.ElementContext;
import com.github.mullerdaniil.trinculo.ui.font.Font;
import com.github.mullerdaniil.trinculo.ui.graphics.FontDrawer;
import com.github.mullerdaniil.trinculo.ui.graphics.Scaler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static com.github.mullerdaniil.trinculo.ui.utils.Constants.*;

@RequiredArgsConstructor
@Component
public class AppPanel extends JPanel {
    private final ElementContext elementContext;
    private final Scaler scaler;
    private final ColorScheme colorScheme;
    private final DataInitializer dataInitializer;

    private final FontDrawer fontDrawer;
    private final Font mainFont;

    public void run() {
        dataInitializer.initializeData();
        setupFrameAndPanel();
        new Timer(TIMER_DELAY, new TimerListener()).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // TODO: impl
        fontDrawer.drawString("abcdefghijklmnopqrstuvwxyz", mainFont, 0, 0, Color.GREEN, g);
    }

    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            repaint();
        }
    }

    private class KeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            elementContext.onKeyPressed(keyCode);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();
            elementContext.onKeyReleased(keyCode);
        }
    }

    private class MouseListener extends MouseAdapter {
        // TODO: impl
    }

    private void setupFrameAndPanel() {
        var frame = new JFrame(WINDOW_NAME);
        frame.setSize(
                scaler.scale(WINDOW_WIDTH_RPX) + WINDOW_WIDTH_MARGIN_PX,
                scaler.scale(WINDOW_HEIGHT_RPX) + WINDOW_HEIGHT_MARGIN_PX
        );
        setSize(
                scaler.scale(WINDOW_WIDTH_RPX),
                scaler.scale(WINDOW_HEIGHT_RPX)
        );
        setFocusTraversalKeysEnabled(true);
        setFocusable(true);
        addKeyListener(new KeyListener());
        addMouseListener(new MouseListener());
        frame.add(this);
        setBackground(colorScheme.getWindowBackgroundColor());
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

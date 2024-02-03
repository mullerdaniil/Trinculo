package com.github.mullerdaniil.trinculo.ui;

import com.github.mullerdaniil.trinculo.engine.DataInitializer;
import com.github.mullerdaniil.trinculo.ui.animation.base.AnimationContext;
import com.github.mullerdaniil.trinculo.ui.color.ColorScheme;
import com.github.mullerdaniil.trinculo.ui.element.TextDisplay;
import com.github.mullerdaniil.trinculo.ui.element.TextLabel;
import com.github.mullerdaniil.trinculo.ui.element.base.ElementContext;
import com.github.mullerdaniil.trinculo.ui.graphics.Scaler;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    private final AnimationContext animationContext;
    private final TextLabel applicationNameLabel;

    public void run() {
        dataInitializer.initializeData();
        setupFrameAndPanel();
        new Timer(TIMER_DELAY, new TimerListener()).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        elementContext.draw(g);
    }

    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            animationContext.update();
            repaint();
        }
    }

    @Autowired
    private TextDisplay weatherDisplay;

    private class KeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            elementContext.onKeyPressed(keyCode);

            // TODO: delete
            if (keyCode == KeyEvent.VK_SPACE) {
                weatherDisplay.setText("544");
            }
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

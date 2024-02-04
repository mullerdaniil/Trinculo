package com.github.mullerdaniil.trinculo.ui.animation;

import com.github.mullerdaniil.trinculo.ui.animation.base.Animation;
import com.github.mullerdaniil.trinculo.ui.color.ColorScheme;
import com.github.mullerdaniil.trinculo.ui.element.base.EditableTextDisplay;
import lombok.RequiredArgsConstructor;

import static com.github.mullerdaniil.trinculo.ui.color.ColorUtils.transformColor;

@RequiredArgsConstructor
public class EditableTextDisplaySetSymbolColorAnimation extends Animation {
    private final EditableTextDisplay editableTextDisplay;
    private final int position;
    private final ColorScheme colorScheme;
    private final long duration;
    private long elapsedTicks = 0;

    @Override
    public void update() {
        if (elapsedTicks >= duration) {
            setAlive(false);
            return;
        }

        boolean isAscending = elapsedTicks <= duration / 2.0;
        double degree;
        if (isAscending) {
            degree = elapsedTicks / (duration / 2.0);
        } else {
            degree = (duration - elapsedTicks) / (duration / 2.0);
        }
        editableTextDisplay.setSymbolColor(transformColor(colorScheme.getTextLabelTextColor(), colorScheme.getTextLabelTextFlashColor(), degree), position);
        elapsedTicks++;
    }
}

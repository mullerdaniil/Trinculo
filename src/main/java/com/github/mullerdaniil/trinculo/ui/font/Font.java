package com.github.mullerdaniil.trinculo.ui.font;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.github.mullerdaniil.trinculo.ui.utils.Constants.ENCODED_GLYPH_NON_ACTIVE_CHAR_SET;
import static com.github.mullerdaniil.trinculo.ui.utils.Constants.ENCODED_GLYPH_SKIPPED_CHAR_SET;

public class Font {
    private final boolean isCaseSensitive;

    @Getter
    private final int emptyGlyphWidth;
    private final Map<Character, Glyph> glyphMap = new HashMap<>();

    @JsonCreator
    public Font(@JsonProperty("isCaseSensitive") boolean isCaseSensitive,
                @JsonProperty("emptyGlyphWidth") int emptyGlyphWidth,
                @JsonProperty("encodedGlyphs") List<EncodedGlyph> encodedGlyphs) {
        this.isCaseSensitive = isCaseSensitive;
        this.emptyGlyphWidth = emptyGlyphWidth;
        encodedGlyphs.forEach(encodedGlyph -> glyphMap.put(encodedGlyph.character(), decodeGlyph(encodedGlyph)));
    }

    public Glyph getGlyph(char character) {
        if (isCaseSensitive) {
            return glyphMap.get(character);
        }
        if (glyphMap.get(Character.toLowerCase(character)) != null) {
            return glyphMap.get(Character.toLowerCase(character));
        }
        return glyphMap.get(Character.toUpperCase(character));
    }

    private Glyph decodeGlyph(EncodedGlyph encodedGlyph) {
        String encodedGlyphString = encodedGlyph.encodedGlyphString();
        for (char skippedCharacter : ENCODED_GLYPH_SKIPPED_CHAR_SET) {
            encodedGlyphString = encodedGlyphString.replace(String.valueOf(skippedCharacter), "");
        }

        int stringIndex = 0;
        int height = encodedGlyph.height();
        int width = encodedGlyph.width();
        boolean[][] drawPattern = new boolean[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                char glyphStringCharacter = encodedGlyphString.charAt(stringIndex++);
                if (!ENCODED_GLYPH_NON_ACTIVE_CHAR_SET.contains(glyphStringCharacter)) {
                    drawPattern[y][x] = true;
                }
            }
        }

        return new Glyph(height, width, drawPattern);
    }
}

package com.sky.demo.qua.collect;

import com.google.common.collect.RangeMap;
import com.sky.demo.qua.annotation.Difficulty;
import com.sky.demo.qua.annotation.Exercise;


import java.util.regex.Pattern;

/**
 * As the name implies, the LineView represents a View for a single line of text. It contains the information of how
 * each character is rendered.
 * <p>
 * View is a very import class for java.swing.text package, and very complicate to implement. But you don't need to
 * worry about it!
 * </p>
 * <p>
 * All you need to do it to reveal how each character( word) is rendered through implementing the method
 * {@link #wordAt(int)}.
 * </p>
 * <p>
 * a <i>word</i> is defined as a string that matches <code>^[a-zA-Z0-9_\-]+$</code>
 * </p>
 * 
 * @author sy
 */
@Exercise(name = "LineView", difficulty = Difficulty.HARD, related = { RangeMap.class, Pattern.class })
public class LineView {

    private final String text;

    private final TextMetrics textMetrics;

    /**
     * 
     * @param text a line of text(formed by ascii-only chars) for this view
     * @param textMetrics TextMetrics used to measure the width of each char
     */
    public LineView(String text, TextMetrics textMetrics) {
        this.text = text;
        this.textMetrics = textMetrics;
        // TODO implement this
    }

    public String getText() {
        return text;
    }

    public TextMetrics getTextMetrics() {
        return textMetrics;
    }

    /**
     * return the word at the given x offset.
     * 
     * @param xOffset the offset to check
     * @return the word covering this given x offset, or empty string if the x offset locates on the delimiter
     * @throws IllegalArgumentException if the xOffset is out of boundary
     */
    public String wordAt(int xOffset) {
        // TODO implement this
        return null;
    }

    /**
     * the length of the LineView
     */
    public int length() {
        // TODO implement this
        return 0;
    }

    public interface TextMetrics {
        /**
         * return the width of a character;
         * 
         * @param c the character to be measured
         * @return the width of the specified character
         */
        int charWidth(char c);
    }
}

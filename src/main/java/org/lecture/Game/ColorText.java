package org.lecture.Game;

/**
 * The ColorText class provides constants for colored text output in the console.
 * It defines ANSI escape codes for various text colors and styles.
 */
public class ColorText {
    public static final String YELLOW_BOLD = "\033[1;33m";
    public static final String BLUE_BOLD = "\033[1;34m";
    public static final String GREEN_BOLD = "\033[1;32m";
    public static final String RED_BOLD = "\033[1;31m";

    public static final String RESET_COLOR = "\u001B[0m";
}

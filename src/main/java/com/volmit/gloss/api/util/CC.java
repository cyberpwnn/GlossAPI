package com.volmit.gloss.api.util;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class CC {
    public static final CC BLACK = new CC('0', new Color(0));
    public static final CC DARK_BLUE = new CC('1', new Color(170));
    public static final CC DARK_GREEN = new CC('2', new Color(43520));
    public static final CC DARK_AQUA = new CC('3', new Color(43690));
    public static final CC DARK_RED = new CC('4', new Color(11141120));
    public static final CC DARK_PURPLE = new CC('5', new Color(11141290));
    public static final CC GOLD = new CC('6', new Color(16755200));
    public static final CC GRAY = new CC('7', new Color(11184810));
    public static final CC DARK_GRAY = new CC('8', new Color(5592405));
    public static final CC BLUE = new CC('9', new Color(5592575));
    public static final CC GREEN = new CC('a', new Color(5635925));
    public static final CC AQUA = new CC('b', new Color(5636095));
    public static final CC RED = new CC('c', new Color(16733525));
    public static final CC LIGHT_PURPLE = new CC('d', new Color(16733695));
    public static final CC YELLOW = new CC('e', new Color(16777045));
    public static final CC WHITE = new CC('f', new Color(16777215));
    public static final CC MAGIC = new CC('k');
    public static final CC BOLD = new CC('l');
    public static final CC STRIKETHROUGH = new CC('m');
    public static final CC UNDERLINE = new CC('n');
    public static final CC ITALIC = new CC('o');
    public static final CC RESET = new CC('r');

    public static final CC GLOW = new CC('g', true);
    public static final CC SHINE = new CC('s', true);
    public static final CC RGB = new CC('q', true);
    public static final CC LINK = new CC('i', true);
    public static final CC URL = new CC('h', true);
    public static final CC HEX = new CC('x', true);

    public static final char COLOR_CHAR = '§';
    public static final CC[] values = new CC[]{
            BLACK, DARK_BLUE, DARK_GREEN, DARK_AQUA, DARK_RED,
            DARK_PURPLE, GOLD, GRAY, DARK_GRAY, BLUE, GREEN, AQUA, RED,
            LIGHT_PURPLE, YELLOW, WHITE, MAGIC, BOLD, STRIKETHROUGH,
            UNDERLINE, ITALIC, RESET, GLOW, SHINE, RGB, LINK, URL, HEX
    };
    private final static Map<Character, CC> BY_CHAR = new HashMap<>();
    private static final Pattern STRIP_COLOR_PATTERN = Pattern.compile("(?i)" + COLOR_CHAR + "[0-9A-FK-ORX]");

    private final char code;
    private final Color color;
    private final String toString;
    private final boolean customFormat;

    static {
        for (CC color : values) {
            BY_CHAR.put(color.code, color);
        }
    }

    private CC(char code) {
        this(code, null);
    }

    public CC(char code, Color color) {
        this(code, false, color);
    }

    private CC(char code, boolean customFormat) {
        this(code, customFormat, null);
    }

    public CC(char code, boolean customFormat, Color color) {
        this.code = code;
        this.color = color;
        this.customFormat = customFormat;
        this.toString = new String(new char[]{COLOR_CHAR, code});
    }

    public static CC[] values() {
        return values;
    }

    public char getChar() {
        return code;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return toString;
    }

    public boolean isFormat() {
        return !isColor() && this != RESET;
    }

    public boolean isCustomFormat() {
        return this.customFormat;
    }

    public boolean isColor() {
        return color != null;
    }

    public String mojangValue() {
        return toString;
    }

    public static CC getByChar(char code) {
        return BY_CHAR.get(code);
    }

    public static String stripColor(final String input) {
        if (input == null) {
            return null;
        }

        return STRIP_COLOR_PATTERN.matcher(input).replaceAll("");
    }

    private static final String ALL_CODES = "0123456789AaBbCcDdEeFfKkLlMmNnOoRrGgSsQqIiHhXx";

    public static String translateAlternateColorCodes(char altColorChar, String textToTranslate) {
        char[] b = textToTranslate.toCharArray();
        for (int i = 0; i < b.length - 1; i++) {
            if (b[i] == altColorChar && ALL_CODES.indexOf(b[i + 1]) > -1) {
                b[i] = CC.COLOR_CHAR;
                b[i + 1] = Character.toLowerCase(b[i + 1]);
            }
        }
        return new String(b);
    }

    public static String backTranslateAlternateColorCodes(char altColorChar, String textToTranslate) {
        char[] b = textToTranslate.toCharArray();
        for (int i = 0; i < b.length - 1; i++) {
            if (b[i] == CC.COLOR_CHAR && ALL_CODES.indexOf(b[i + 1]) > -1) {
                b[i] = altColorChar;
                b[i + 1] = Character.toLowerCase(b[i + 1]);
            }
        }
        return new String(b);
    }

    public static String getLastColors(String input) {
        StringBuilder result = new StringBuilder();
        int length = input.length();

        // Search backwards from the end as it is faster
        for (int index = length - 1; index > -1; index--) {
            char section = input.charAt(index);
            if (section == COLOR_CHAR && index < length - 1) {
                char c = input.charAt(index + 1);
                CC color = getByChar(c);

                if (color != null) {
                    result.insert(0, color.toString());

                    // Once we find a color or reset we can stop searching
                    if (color.isColor() || color.equals(RESET)) {
                        break;
                    }
                }
            }
        }

        return result.toString();
    }

    public static class HexColor extends CC {
        private final String hex;

        public HexColor(String hex) {
            this(Color.decode(hex), hex);
        }

        public HexColor(Color color) {
            this(color, "#" + Integer.toHexString(color.getRGB()).substring(2));
        }

        public HexColor(Color color, String hex) {
            super('x', color);
            this.hex = hex;
        }

        @Override
        public String toString() {
            return "[" + hex + "]";
        }

        @Override
        public String mojangValue() {
            StringBuilder sb = new StringBuilder();
            for (char c : hex.substring(1).toCharArray()) {
                sb.append(COLOR_CHAR).append(c);
            }
            return sb.insert(0, super.toString()).toString();
        }
    }

    public static CC fromColor(Color color) {
        return new HexColor(color);
    }

    public static CC fromHex(String value) {
        return new HexColor(value);
    }
}

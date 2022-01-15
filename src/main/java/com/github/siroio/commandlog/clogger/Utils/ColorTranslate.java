package com.github.siroio.commandlog.clogger.Utils;

import java.awt.*;

public class ColorTranslate {

    public static String RGBtoHEX(int r, int g, int b) {
        return String.format("#%02x%02x%02x", r, g, b);
    }

    public static Color HEXtoRGB(String Hex) {
        return Color.getColor(Hex);
    }
}

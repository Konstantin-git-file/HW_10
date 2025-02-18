package ru.elizarov.math;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

public class PowerCalculator {
    public static double calculatePower(String xStr, String yStr) {
        int x = parseInt(xStr); // строку X в число
        int y = parseInt(yStr); // строку Y в число
        return pow(x, y);
    }
}
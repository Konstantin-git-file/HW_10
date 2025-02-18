package ru.elizarov.tools;

import ru.elizarov.geometry.Measurable;

import java.util.List;

public class LengthCalculator {
    public static double calculateTotalLength(List<Measurable> measurables) {
        double totalLength = 0.0;
        for (Measurable measurable : measurables) {
            totalLength += measurable.getLength();
        }
        return totalLength;
    }
}

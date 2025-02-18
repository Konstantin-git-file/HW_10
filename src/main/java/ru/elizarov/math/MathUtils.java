package ru.elizarov.math;

import java.math.BigInteger;

public class MathUtils {
    public static double sum(Number... numbers) {
        double sum = 0.0;

        for (Number number : numbers) {
            if (number instanceof BigInteger) {
                // BigInteger в double
                sum += new BigInteger(number.toString()).doubleValue();
            } else if (number instanceof Fraction) {
                // Fraction в double
                sum += ((Fraction) number).toDouble();
            } else {
                // остальное к double
                sum += number.doubleValue();
            }
        }
        return sum;
    }
}

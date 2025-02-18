package ru.elizarov.math;

import java.util.List;

public class StringCalculator {

    public static double divideFirstByOthers(List<String> strings) {
        // Преобразуем строки в числа, игнорируя нечисловые строки
        List<Double> numbers = strings.stream()
                .filter(s -> s.matches("-?\\d+(\\.\\d+)?")) //является ли строка числом
                .map(Double::parseDouble)
                .toList();
        if (numbers.size() < 2) {
            System.out.println("Недостаточно чисел для выполнения деления.");
            return 0; // TODO можно исключение
        }

        // Первое число — делимое
        double dividend = numbers.get(0);

        // Делим первое число на все остальные числа
        for (int i = 1; i < numbers.size(); i++) {
            double divisor = numbers.get(i);
            if (divisor == 0) {
                System.out.println("Деление на ноль невозможно. Пропуск делителя.");
                continue; // пропускаем деление на ноль
            }
            dividend /= divisor;
        }

        return dividend;
    }
}
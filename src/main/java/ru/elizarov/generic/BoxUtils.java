package ru.elizarov.generic;

import ru.elizarov.geometry.Point3D;

import java.util.List;
import java.util.OptionalDouble;
import java.util.Random;

public class BoxUtils {
    public static <T> void processBox(Box<T> box) throws BoxEmptyException {
        T value = box.get();
        System.out.println("Извлеченное значение: " + value);
    }

    // 6.2.2.
    public static <T extends Number & Comparable<T>> double findMax(List<Box<? extends Number>> boxes) throws BoxEmptyException {
        OptionalDouble max = boxes.stream()
                .filter(box -> !box.isEmpty())
                .mapToDouble(box -> box.getContent().doubleValue())
                .max();

        if (max.isPresent()) {
            return max.getAsDouble();
        } else {
            throw new BoxEmptyException("Все коробки пусты!");
        }
    }
    // 6.2.3.
    public static <T> void putRandomPoint(Box<T> box) throws BoxNotEmptyException {
        if (box.isEmpty()) {
            Random random = new Random();
            Point3D point = new Point3D((int) (random.nextDouble() * 100), (int) (random.nextDouble() * 100), (int) (random.nextDouble() * 100));
            box.put((T) point);  // кастим к типу T и кладем в коробку
            System.out.println("Случайная точка добавлена в коробку: " + point);
        } else {
            throw new BoxNotEmptyException("Коробка уже занята!");
        }
    }
}
package ru.elizarov.animals;
import java.util.Random;

public class Parrot extends Bird {
    private final String text;
    private static final Random random = new Random();

    public Parrot(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Текст для попугая не может быть пустым.");
        }
        this.text = text;
    }

    @Override
    public void sing() {
        int length = text.length();
        int n = random.nextInt(length) + 1; // Случайное количество символов от 1 до длины текста
        System.out.println(text.substring(0, n));
    }
}
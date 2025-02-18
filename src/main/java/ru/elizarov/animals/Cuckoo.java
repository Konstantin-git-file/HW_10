package ru.elizarov.animals;
import java.util.Random;

public class Cuckoo extends Bird {
    private static final Random random = new Random();

    @Override
    public void sing() {
        int count = random.nextInt(10) + 1;
        for (int i = 0; i < count; i++) {
            System.out.println("ку-ку!");
        }
    }
}
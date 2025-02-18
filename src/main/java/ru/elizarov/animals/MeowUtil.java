package ru.elizarov.animals;

import java.util.List;

class MeowUtil {
    public static void makeThemMeow(List<Meowable> meowables) {
        for (Meowable meowable : meowables) {
            meowable.meow();
        }
    }
}

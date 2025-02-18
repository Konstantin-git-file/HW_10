package ru.elizarov.animals;

public class Cat implements Meowable {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public void meow() {
        System.out.println(name + ": мяу!");
    }

    public void meow(int n) {
        StringBuilder meowString = new StringBuilder(name + ": ");
        for (int i = 0; i < n; i++) {
            meowString.append("мяу");
            if (i < n - 1) {
                meowString.append("-");
            }
        }
        meowString.append("!");
        System.out.println(meowString);
    }

    @Override
    public String toString() {
        return "кот: " + name;
    }
}
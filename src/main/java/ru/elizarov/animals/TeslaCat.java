package ru.elizarov.animals;

class TeslaCat implements Meowable {
    private String model;

    public TeslaCat(String model) {
        this.model = model;
    }

    public void meow() {
        System.out.println(model + " - Elon is the best, how could it be otherwise?");
    }
}


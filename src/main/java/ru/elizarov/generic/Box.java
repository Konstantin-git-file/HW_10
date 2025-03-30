package ru.elizarov.generic;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Box<T> {
    @Getter
    private T content;

    public void put(T item) throws BoxNotEmptyException {
        if (content != null) {
            throw new BoxNotEmptyException("Коробка уже занята!");
        }
        this.content = item;
    }

    public T get() {
        if (content == null) {
            throw new BoxEmptyException("Коробка пуста!");
        }
        T item = content;
        content = null;
        return item;
    }

    public boolean isEmpty() {
        return content == null;
    }

    public void extractAndPrint() {
        try {
            System.out.println("Извлеченное значение: " + get());
        } catch (BoxEmptyException e) {
            System.out.println(e.getMessage());
        }
    }
}

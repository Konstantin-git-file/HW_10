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

    // для извлечения объекта
    public T get() throws BoxEmptyException {
        if (content == null) {
            throw new BoxEmptyException("Коробка пуста!");
        }
        T item = content;
        content = null;
        return item;
    }

    // для проверки
    public boolean isEmpty() {
        return content == null;
    }

    public void extractAndPrint() throws BoxEmptyException {
        System.out.println("Извлеченное значение: " + get());
    }
}

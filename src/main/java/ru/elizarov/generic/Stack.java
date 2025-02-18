package ru.elizarov.generic;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.LinkedList;

@NoArgsConstructor
public class Stack<T> {
    @Getter
    private int size;
    private LinkedList<T> elements = new LinkedList<>();

    public void push(T item) {
        elements.addFirst(item);
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Стек пуст");
        }
        return elements.removeFirst();
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Стек пуст");
        }
        return elements.getFirst();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }


}



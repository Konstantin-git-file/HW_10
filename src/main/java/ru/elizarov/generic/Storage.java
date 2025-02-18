package ru.elizarov.generic;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class Storage<T> {
    private final T value;

    public T getValue(T alternative) {
        return (value != null) ? value : alternative;
    }
}

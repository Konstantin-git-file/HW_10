package ru.elizarov.generic;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@FunctionalInterface
public interface Comparable<T> {
    int compare(T obj);
}

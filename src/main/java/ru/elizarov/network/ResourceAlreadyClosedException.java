package ru.elizarov.network;

public class ResourceAlreadyClosedException extends RuntimeException {
    // Конструктор без параметров
    public ResourceAlreadyClosedException() {
        super("Попытка использования уже закрытого ресурса.");
    }
}

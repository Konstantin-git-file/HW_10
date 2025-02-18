package ru.elizarov.network;

import lombok.Getter;

import java.util.Random;

public class Connection {
    @Getter
    private final String address;
    private boolean isOpen;
    private final Random random;

    // Конструктор: создается с указанием адреса
    public Connection(String address) {
        if (address == null || address.isEmpty()) {
            throw new IllegalArgumentException("Адрес подключения не может быть пустым.");
        }
        this.address = address;
        this.isOpen = true; // Связь считается открытой
        this.random = new Random();
    }

    // Закрытие соединения
    public void close() {
        if (!isOpen) {
            return; // Соединение уже закрыто
        }
        isOpen = false;
        System.out.println("Подключение закрыто: " + address);
    }

    // Запрос данных
    public String fetchData() throws NetworkConnectionException {
        if (!isOpen) {
            throw new ResourceAlreadyClosedException();
        }

        // Случайным образом выбрасываем исключение или возвращаем данные
        if (random.nextBoolean()) {
            throw new NetworkConnectionException("Проблемы с подключением к: " + address);
        }

        return "test connection";
    }

    // Проверка состояния соединения
    public boolean isOpen() {
        return isOpen;
    }

}
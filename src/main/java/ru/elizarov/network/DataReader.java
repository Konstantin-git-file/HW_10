package ru.elizarov.network;

public class DataReader {
    public static void readData() {
        Connection connection = null;
        try {
            //   cоздаем подключение
            connection = new Connection("ermakov.edu");

            // выводим  10 строк
            for (int i = 1; i <= 10; i++) {
                try {
                    String data = connection.fetchData();
                    System.out.println("Строка " + i + ": " + data);
                } catch (NetworkConnectionException e) {
                    System.err.println("Ошибка сети на строке " + i + ": " + e.getMessage());
                }
            }
        } catch (ResourceAlreadyClosedException e) {
            System.err.println("Ошибка: попытка работы с закрытым ресурсом. " + e.getMessage());
        } finally {
            if (connection != null && connection.isOpen()) {
                connection.close();
            }
            System.out.println("Соединение закрыто.");
        }
    }
}
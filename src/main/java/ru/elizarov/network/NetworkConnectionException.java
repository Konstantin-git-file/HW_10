package ru.elizarov.network;

public class NetworkConnectionException extends Exception {
    public NetworkConnectionException() {
        super();
    }

    public NetworkConnectionException(String message) {
        super(message);
    }

    // конструктор с причиной
    public NetworkConnectionException(Throwable cause) {
        super(cause);
    }

    // конструктор с сообщением и причиной
    public NetworkConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}
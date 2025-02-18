package ru.elizarov.study;

public class InvalidGradeException extends RuntimeException {
    public InvalidGradeException() {
        super();
    }

    public InvalidGradeException(String message) {
        super(message);
    }
}
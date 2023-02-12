package ru.labs.lab08.matrixes;

public class MatrixException extends RuntimeException {
    final private String message;

    public MatrixException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

package ru.linkshortener.exception;

public class NotFoundExeption extends LinkShortenerException {
    public NotFoundExeption(String message, Exception e) {
        super(message, e);
    }

    public NotFoundExeption(String message) {
        super(message);
    }
}

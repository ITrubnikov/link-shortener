package ru.linkshortener.exception;

public class LinkShortenerException extends RuntimeException {
    public LinkShortenerException(String message, Exception e) {
        super(message, e);
    }

    public LinkShortenerException(String message) {
        super(message);
    }
}

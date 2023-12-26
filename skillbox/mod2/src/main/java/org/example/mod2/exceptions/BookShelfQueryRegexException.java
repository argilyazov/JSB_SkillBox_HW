package org.example.mod2.exceptions;

public class BookShelfQueryRegexException extends Exception{
    private final String message;

    public BookShelfQueryRegexException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

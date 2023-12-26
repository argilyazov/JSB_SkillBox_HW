package org.example.mod2.exceptions;

public class BookShelfUploadFileException extends Exception {
    private final String message;

    public BookShelfUploadFileException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

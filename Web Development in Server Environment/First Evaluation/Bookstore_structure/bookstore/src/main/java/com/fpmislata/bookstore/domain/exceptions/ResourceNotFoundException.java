package com.fpmislata.bookstore.domain.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    private static final String DESCRIPTION = "Resource not Found";

    public ResourceNotFoundException(String message) {
        super(DESCRIPTION + ". " + message);
    }
}

package com.fpmislata.bookstore.common.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    private static final String DESCRIPTION = "Resource not Found";

    public ResourceNotFoundException(String message) {
        super(DESCRIPTION + ". " + message);
    }
}

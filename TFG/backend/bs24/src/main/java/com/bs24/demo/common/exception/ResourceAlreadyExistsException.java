package com.bs24.demo.common.exception;

public class ResourceAlreadyExistsException extends RuntimeException {
    private static final String DESCRIPTION = "Resource already exists";

    public ResourceAlreadyExistsException(String message) {
        super(DESCRIPTION + ". " + message);
    }
}

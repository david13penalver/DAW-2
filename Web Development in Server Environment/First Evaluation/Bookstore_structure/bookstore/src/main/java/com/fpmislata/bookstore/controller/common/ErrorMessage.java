package com.fpmislata.bookstore.controller.common;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ErrorMessage {
    private final String error;
    private final String message;

    public ErrorMessage(String error, String message) {
        this.error = error;
        this.message = message;
    }
}

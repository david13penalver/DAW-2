package com.fpmislata.bookstore.common.error;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ErrorMessage {
    private final String error;
    private final int message;

    public ErrorMessage(String error, int message) {
        this.error = error;
        this.message = message;
    }
}

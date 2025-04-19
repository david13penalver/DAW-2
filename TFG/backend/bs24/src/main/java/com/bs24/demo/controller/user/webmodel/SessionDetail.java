package com.bs24.demo.controller.user.webmodel;

public record SessionDetail(
        int sessionId,
        String name,
        String description,
        String dateCreation,
        UserDetail user
) {
}

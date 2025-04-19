package com.bs24.demo.controller.user.webmodel;

public record UserDetail(
        int userId,
        String name,
        String email,
        String password,
        String dateRegister
) {
}

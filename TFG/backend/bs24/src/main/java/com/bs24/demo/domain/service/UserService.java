package com.bs24.demo.domain.service;

import com.bs24.demo.domain.model.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findById(int userId);

    void save(User user);
}

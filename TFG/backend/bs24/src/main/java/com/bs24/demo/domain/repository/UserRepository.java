package com.bs24.demo.domain.repository;

import com.bs24.demo.domain.model.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(int userId);

    void save(User user);
}

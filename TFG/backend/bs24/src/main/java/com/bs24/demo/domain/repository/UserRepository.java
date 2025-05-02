package com.bs24.demo.domain.repository;

import com.bs24.demo.domain.model.ListWithCount;
import com.bs24.demo.domain.model.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(int userId);

    void save(User user);

    void delete(int id);

    ListWithCount<User> getAll(int page, int pageSize);
}

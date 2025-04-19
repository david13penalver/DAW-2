package com.bs24.demo.persistence.repository.imp;

import com.bs24.demo.domain.model.User;
import com.bs24.demo.domain.repository.UserRepository;
import com.bs24.demo.persistence.dao.db.UserDaoDb;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserDaoDb userDaoDb;

    @Override
    public Optional<User> findById(int userId) {
        return userDaoDb.findById(userId);
    }

    @Override
    public void save(User user) {
        userDaoDb.save(user);
    }
}

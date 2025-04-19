package com.bs24.demo.persistence.dao.db.jpa;

import com.bs24.demo.domain.model.ListWithCount;
import com.bs24.demo.domain.model.User;
import com.bs24.demo.persistence.dao.db.UserDaoDb;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserDaoDbImpl implements UserDaoDb {

    @Override
    public List<User> getAll() {
        return List.of();
    }

    @Override
    public ListWithCount<User> getAll(int page, int size) {
        return null;
    }

    @Override
    public Optional<User> findById(long id) {
        return Optional.empty();
    }

    @Override
    public long insert(User user) {
        return 0;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public User save(User user) {
        return null;
    }
}

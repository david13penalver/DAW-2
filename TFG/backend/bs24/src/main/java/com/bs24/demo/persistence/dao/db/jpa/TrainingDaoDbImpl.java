package com.bs24.demo.persistence.dao.db.jpa;

import com.bs24.demo.persistence.dao.db.TrainingDaoDb;

import java.util.List;
import java.util.Optional;

public class TrainingDaoDbImpl implements TrainingDaoDb {
    @Override
    public List getAll() {
        return List.of();
    }

    @Override
    public Optional findById(long id) {
        return Optional.empty();
    }

    @Override
    public long insert(Object o) {
        return 0;
    }

    @Override
    public void update(Object o) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public Object save(Object o) {
        return null;
    }
}

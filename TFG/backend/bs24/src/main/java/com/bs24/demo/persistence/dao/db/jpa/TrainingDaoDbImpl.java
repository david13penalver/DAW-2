package com.bs24.demo.persistence.dao.db.jpa;

import com.bs24.demo.domain.model.ListWithCount;
import com.bs24.demo.domain.model.Training;
import com.bs24.demo.persistence.dao.db.TrainingDaoDb;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TrainingDaoDbImpl implements TrainingDaoDb {

    @Override
    public List<Training> getAll() {
        return List.of();
    }

    @Override
    public ListWithCount<Training> getAll(int page, int size) {
        return null;
    }

    @Override
    public Optional<Training> findById(long id) {
        return Optional.empty();
    }

    @Override
    public long insert(Training training) {
        return 0;
    }

    @Override
    public void update(Training training) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public Training save(Training training) {
        return null;
    }
}

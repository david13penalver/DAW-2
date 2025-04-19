package com.bs24.demo.persistence.dao.db.jpa;

import com.bs24.demo.domain.model.ListWithCount;
import com.bs24.demo.domain.model.SessionExercises;
import com.bs24.demo.persistence.dao.db.SessionExercisesDaoDb;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class SessionExercisesDaoDbImpl implements SessionExercisesDaoDb {

    @Override
    public List<SessionExercises> getAll() {
        return List.of();
    }

    @Override
    public ListWithCount<SessionExercises> getAll(int page, int size) {
        return null;
    }

    @Override
    public Optional<SessionExercises> findById(long id) {
        return Optional.empty();
    }

    @Override
    public long insert(SessionExercises sessionExercises) {
        return 0;
    }

    @Override
    public void update(SessionExercises sessionExercises) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public SessionExercises save(SessionExercises sessionExercises) {
        return null;
    }
}

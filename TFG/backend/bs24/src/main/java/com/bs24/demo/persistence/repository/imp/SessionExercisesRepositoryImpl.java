package com.bs24.demo.persistence.repository.imp;

import com.bs24.demo.domain.model.ListWithCount;
import com.bs24.demo.domain.model.SessionExercises;
import com.bs24.demo.domain.repository.SessionExercisesRepository;
import com.bs24.demo.persistence.dao.db.SessionExercisesDaoDb;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class SessionExercisesRepositoryImpl implements SessionExercisesRepository {

    private final SessionExercisesDaoDb sessionExercisesDaoDb;
    @Override
    public ListWithCount<SessionExercises> getAll(int page, int pageSize) {
        return sessionExercisesDaoDb.getAll(page, pageSize);
    }

    @Override
    public Optional<SessionExercises> findById(int sessionId) {
        return sessionExercisesDaoDb.findById(sessionId);
    }

    @Override
    public void save(SessionExercises sessionExercises) {
        sessionExercisesDaoDb.save(sessionExercises);
    }

    @Override
    public ListWithCount<SessionExercises> getAllBySessionId(int sessionId, int page, int pageSize) {
        return sessionExercisesDaoDb.getAllBySessionId(sessionId, page, pageSize);
    }
}

package com.bs24.demo.domain.service;

import com.bs24.demo.domain.model.ListWithCount;
import com.bs24.demo.domain.model.SessionExercises;

import java.util.Optional;

public interface SessionExercisesService {
    ListWithCount<SessionExercises> getAll(int page, int pageSize);

    Optional<SessionExercises> findById(int sessionId);

    void save(SessionExercises sessionExercises);

    ListWithCount<SessionExercises> getAllBySessionId(int sessionId, int page, int pageSize);

    void delete(int id);
}

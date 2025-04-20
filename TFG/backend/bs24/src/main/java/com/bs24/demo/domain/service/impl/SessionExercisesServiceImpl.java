package com.bs24.demo.domain.service.impl;

import com.bs24.demo.common.annotation.DomainService;
import com.bs24.demo.domain.model.ListWithCount;
import com.bs24.demo.domain.model.SessionExercises;
import com.bs24.demo.domain.repository.SessionExercisesRepository;
import com.bs24.demo.domain.service.SessionExercisesService;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@DomainService
@RequiredArgsConstructor
public class SessionExercisesServiceImpl implements SessionExercisesService {

    private final SessionExercisesRepository sessionExercisesRepository;

    @Override
    public ListWithCount<SessionExercises> getAll(int page, int pageSize) {
        return sessionExercisesRepository.getAll(page, pageSize);
    }

    @Override
    public Optional<SessionExercises> findById(int sessionId) {
        return sessionExercisesRepository.findById(sessionId);
    }

    @Override
    public void save(SessionExercises sessionExercises) {
        sessionExercisesRepository.save(sessionExercises);
    }

    @Override
    public ListWithCount<SessionExercises> getAllBySessionId(int sessionId, int page, int pageSize) {
        return sessionExercisesRepository.getAllBySessionId(sessionId, page, pageSize);
    }

    @Override
    public void delete(int id) {
        sessionExercisesRepository.delete(id);
    }
}

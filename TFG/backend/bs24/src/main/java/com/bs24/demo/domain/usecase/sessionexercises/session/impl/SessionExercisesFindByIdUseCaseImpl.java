package com.bs24.demo.domain.usecase.sessionexercises.session.impl;

import com.bs24.demo.common.annotation.DomainTransactional;
import com.bs24.demo.common.annotation.DomainUseCase;
import com.bs24.demo.common.exception.ResourceNotFoundException;
import com.bs24.demo.domain.model.SessionExercises;
import com.bs24.demo.domain.service.SessionExercisesService;
import com.bs24.demo.domain.usecase.sessionexercises.session.SessionExercisesFindByIdUseCase;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class SessionExercisesFindByIdUseCaseImpl implements SessionExercisesFindByIdUseCase {

    private final SessionExercisesService sessionExercisesService;

    @Override
    public SessionExercises execute(int sessionId) {
        return sessionExercisesService.findById(sessionId)
                .orElseThrow(() -> new ResourceNotFoundException("Exercise not found"));
    }
}

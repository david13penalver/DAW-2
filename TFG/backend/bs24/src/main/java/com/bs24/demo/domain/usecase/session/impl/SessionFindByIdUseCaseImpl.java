package com.bs24.demo.domain.usecase.session.impl;

import com.bs24.demo.common.annotation.DomainTransactional;
import com.bs24.demo.common.annotation.DomainUseCase;
import com.bs24.demo.common.exception.ResourceNotFoundException;
import com.bs24.demo.domain.model.Exercise;
import com.bs24.demo.domain.model.Session;
import com.bs24.demo.domain.service.ExerciseService;
import com.bs24.demo.domain.service.SessionService;
import com.bs24.demo.domain.usecase.exercise.ExerciseFindByIdUseCase;
import com.bs24.demo.domain.usecase.session.SessionFindByIdUseCase;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class SessionFindByIdUseCaseImpl implements SessionFindByIdUseCase {

    private final SessionService sessionService;

    @Override
    public Session execute(int sessionId) {
        return sessionService.findById(sessionId)
                .orElseThrow(() -> new ResourceNotFoundException("Exercise not found"));
    }
}

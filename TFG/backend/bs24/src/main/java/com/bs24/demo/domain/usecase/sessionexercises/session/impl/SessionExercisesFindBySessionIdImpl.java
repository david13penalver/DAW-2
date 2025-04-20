package com.bs24.demo.domain.usecase.sessionexercises.session.impl;

import com.bs24.demo.common.annotation.DomainTransactional;
import com.bs24.demo.common.annotation.DomainUseCase;
import com.bs24.demo.domain.model.ListWithCount;
import com.bs24.demo.domain.model.SessionExercises;
import com.bs24.demo.domain.service.SessionExercisesService;
import com.bs24.demo.domain.usecase.sessionexercises.session.SessionExercisesFindBySessionId;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class SessionExercisesFindBySessionIdImpl implements SessionExercisesFindBySessionId {

    private final SessionExercisesService sessionExercisesService;

    @Override
    public ListWithCount<SessionExercises> execute(int sessionId, int page, int pageSize) {
        return sessionExercisesService.getAllBySessionId(sessionId, page, pageSize);
    }
}

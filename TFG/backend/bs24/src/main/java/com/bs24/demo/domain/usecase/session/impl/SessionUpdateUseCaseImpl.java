package com.bs24.demo.domain.usecase.session.impl;

import com.bs24.demo.common.annotation.DomainTransactional;
import com.bs24.demo.common.annotation.DomainUseCase;
import com.bs24.demo.domain.model.Session;
import com.bs24.demo.domain.service.SessionService;
import com.bs24.demo.domain.usecase.session.SessionUpdateUseCase;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class SessionUpdateUseCaseImpl implements SessionUpdateUseCase {

    private final SessionService sessionService;

    @Override
    public void execute(Session session) {
        sessionService.save(session);
    }
}

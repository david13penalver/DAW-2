package com.bs24.demo.domain.usecase.session.impl;

import com.bs24.demo.common.annotation.DomainTransactional;
import com.bs24.demo.common.annotation.DomainUseCase;
import com.bs24.demo.domain.service.SessionService;
import com.bs24.demo.domain.usecase.session.SessionDeleteUseCase;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class SessionDeleteUseCaseImpl implements SessionDeleteUseCase {

    private final SessionService sessionService;

    @Override
    public void execute(int id) {
        sessionService.delete(id);
    }
}

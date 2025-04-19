package com.bs24.demo.domain.usecase.session.impl;

import com.bs24.demo.common.annotation.DomainTransactional;
import com.bs24.demo.common.annotation.DomainUseCase;
import com.bs24.demo.domain.model.ListWithCount;
import com.bs24.demo.domain.model.Session;
import com.bs24.demo.domain.service.SessionService;
import com.bs24.demo.domain.usecase.session.SessionGetAllUseCase;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class SessionGetAllUseCaseImpl implements SessionGetAllUseCase {

    private final SessionService sessionService;

    @Override
    public ListWithCount<Session> execute(int page, int pageSize) {
        return sessionService.getAll(page, pageSize);
    }
}

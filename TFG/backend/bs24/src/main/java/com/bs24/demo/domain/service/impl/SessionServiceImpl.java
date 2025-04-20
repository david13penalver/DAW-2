package com.bs24.demo.domain.service.impl;

import com.bs24.demo.common.annotation.DomainService;
import com.bs24.demo.domain.model.ListWithCount;
import com.bs24.demo.domain.model.Session;
import com.bs24.demo.domain.repository.SessionRepository;
import com.bs24.demo.domain.service.SessionService;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@DomainService
@RequiredArgsConstructor
public class SessionServiceImpl implements SessionService {

    private final SessionRepository sessionRepository;

    @Override
    public ListWithCount<Session> getAll(int page, int pageSize) {
        return sessionRepository.getAll(page, pageSize);
    }

    @Override
    public Optional<Session> findById(int sessionId) {
        return sessionRepository.findById(sessionId);
    }

    @Override
    public void save(Session session) {
        sessionRepository.save(session);
    }

    @Override
    public void delete(int id) {
        sessionRepository.delete(id);
    }
}

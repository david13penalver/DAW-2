package com.bs24.demo.domain.service;

import com.bs24.demo.domain.model.ListWithCount;
import com.bs24.demo.domain.model.Session;

import java.util.Optional;

public interface SessionService {
    ListWithCount<Session> getAll(int page, int pageSize);

    Optional<Session> findById(int sessionId);

    void save(Session session);
}

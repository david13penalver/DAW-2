package com.bs24.demo.persistence.repository.imp;

import com.bs24.demo.domain.model.ListWithCount;
import com.bs24.demo.domain.model.Session;
import com.bs24.demo.domain.repository.SessionRepository;
import com.bs24.demo.persistence.dao.db.SessionDaoDb;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class SessionRepositoryImpl implements SessionRepository {

    private final SessionDaoDb sessionDaoDb;

    @Override
    public ListWithCount<Session> getAll(int page, int pageSize) {
        return sessionDaoDb.getAll(page, pageSize);
    }

    @Override
    public Optional<Session> findById(int sessionId) {
        return sessionDaoDb.findById(sessionId);
    }

    @Override
    public void save(Session session) {
        sessionDaoDb.save(session);
    }
}

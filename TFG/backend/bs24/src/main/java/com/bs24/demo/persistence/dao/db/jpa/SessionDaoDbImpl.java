package com.bs24.demo.persistence.dao.db.jpa;

import com.bs24.demo.domain.model.ListWithCount;
import com.bs24.demo.domain.model.Session;
import com.bs24.demo.persistence.dao.db.SessionDaoDb;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class SessionDaoDbImpl implements SessionDaoDb {

    @Override
    public List<Session> getAll() {
        return List.of();
    }

    @Override
    public ListWithCount<Session> getAll(int page, int size) {
        return null;
    }

    @Override
    public Optional<Session> findById(long id) {
        return Optional.empty();
    }

    @Override
    public long insert(Session session) {
        return 0;
    }

    @Override
    public void update(Session session) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public Session save(Session session) {
        return null;
    }
}

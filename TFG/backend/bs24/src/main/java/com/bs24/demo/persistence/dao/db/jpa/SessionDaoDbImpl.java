package com.bs24.demo.persistence.dao.db.jpa;

import com.bs24.demo.domain.model.ListWithCount;
import com.bs24.demo.domain.model.Session;
import com.bs24.demo.persistence.dao.db.SessionDaoDb;
import com.bs24.demo.persistence.dao.db.jpa.entity.ExerciseJPA;
import com.bs24.demo.persistence.dao.db.jpa.entity.SessionJPA;
import com.bs24.demo.persistence.dao.db.jpa.mapper.ExerciseJPAMapper;
import com.bs24.demo.persistence.dao.db.jpa.mapper.SessionJPAMapper;
import com.bs24.demo.persistence.dao.db.jpa.repository.SessionJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class SessionDaoDbImpl implements SessionDaoDb {

    private final SessionJPARepository sessionJPARepository;

    @Override
    public List<Session> getAll() {
        return List.of();
    }

    @Override
    public ListWithCount<Session> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<SessionJPA> sessionJPAPage = sessionJPARepository.findAll(pageable);
        return new ListWithCount<>(
                sessionJPAPage.stream()
                        .map(SessionJPAMapper.INSTANCE::toSession)
                        .toList(),
                sessionJPAPage.getTotalElements()
        );
    }

    @Override
    public Optional<Session> findById(long id) {
        return sessionJPARepository.findById(id)
                .map(SessionJPAMapper.INSTANCE::toSession);
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
        sessionJPARepository.deleteById(id);
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public Session save(Session session) {
        SessionJPA sessionJPA = SessionJPAMapper.INSTANCE.toSessionJPA(session);
        return SessionJPAMapper.INSTANCE.toSession(sessionJPARepository.save(sessionJPA));
    }
}

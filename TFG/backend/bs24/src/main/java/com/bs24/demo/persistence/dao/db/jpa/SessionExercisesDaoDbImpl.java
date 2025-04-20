package com.bs24.demo.persistence.dao.db.jpa;

import com.bs24.demo.domain.model.ListWithCount;
import com.bs24.demo.domain.model.SessionExercises;
import com.bs24.demo.persistence.dao.db.SessionExercisesDaoDb;
import com.bs24.demo.persistence.dao.db.jpa.entity.SessionExercisesJPA;
import com.bs24.demo.persistence.dao.db.jpa.entity.SessionJPA;
import com.bs24.demo.persistence.dao.db.jpa.mapper.SessionExercisesJPAMapper;
import com.bs24.demo.persistence.dao.db.jpa.mapper.SessionJPAMapper;
import com.bs24.demo.persistence.dao.db.jpa.repository.SessionExercisesJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class SessionExercisesDaoDbImpl implements SessionExercisesDaoDb {

    private final SessionExercisesJPARepository sessionExercisesJPARepository;

    @Override
    public List<SessionExercises> getAll() {
        return List.of();
    }

    @Override
    public ListWithCount<SessionExercises> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<SessionExercisesJPA> sessionExercisesJPAPage = sessionExercisesJPARepository.findAll(pageable);
        return new ListWithCount<>(
                sessionExercisesJPAPage.stream()
                        .map(SessionExercisesJPAMapper.INSTANCE::toSessionExercises)
                        .toList(),
                sessionExercisesJPAPage.getTotalElements()
        );
    }

    @Override
    public Optional<SessionExercises> findById(long id) {
        return sessionExercisesJPARepository.findById(id)
                .map(SessionExercisesJPAMapper.INSTANCE::toSessionExercises);
    }

    @Override
    public long insert(SessionExercises sessionExercises) {
        return 0;
    }

    @Override
    public void update(SessionExercises sessionExercises) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public SessionExercises save(SessionExercises sessionExercises) {
        SessionExercisesJPA sessionExercisesJPA = SessionExercisesJPAMapper.INSTANCE.toSessionExercisesJPA(sessionExercises);
        return SessionExercisesJPAMapper.INSTANCE.toSessionExercises(sessionExercisesJPARepository.save(sessionExercisesJPA));
    }

    @Override
    public ListWithCount<SessionExercises> getAllBySessionId(int sessionId, int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<SessionExercisesJPA> sessionExercisesJPAPage = sessionExercisesJPARepository.findBySession_SessionId(sessionId, pageable);
        return new ListWithCount<>(
                sessionExercisesJPAPage.stream()
                        .map(SessionExercisesJPAMapper.INSTANCE::toSessionExercises)
                        .toList(),
                sessionExercisesJPAPage.getTotalElements()
        );
    }
}

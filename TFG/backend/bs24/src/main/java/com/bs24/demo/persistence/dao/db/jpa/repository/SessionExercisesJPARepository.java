package com.bs24.demo.persistence.dao.db.jpa.repository;

import com.bs24.demo.persistence.dao.db.jpa.entity.SessionExercisesJPA;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SessionExercisesJPARepository extends JpaRepository<SessionExercisesJPA, Long> {
    Page<SessionExercisesJPA> findBySession_SessionId(int sessionId, Pageable pageable);
}

package com.bs24.demo.persistence.dao.db.jpa.repository;

import com.bs24.demo.persistence.dao.db.jpa.entity.SessionJPA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionJPARepository extends JpaRepository<SessionJPA, Long> {
}

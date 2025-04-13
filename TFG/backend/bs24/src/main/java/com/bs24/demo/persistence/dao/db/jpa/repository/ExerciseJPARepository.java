package com.bs24.demo.persistence.dao.db.jpa.repository;

import com.bs24.demo.persistence.dao.db.jpa.entity.ExerciseJPA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseJPARepository extends JpaRepository<ExerciseJPA, Long> {
}

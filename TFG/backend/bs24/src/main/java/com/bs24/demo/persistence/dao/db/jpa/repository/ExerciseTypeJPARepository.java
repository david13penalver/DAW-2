package com.bs24.demo.persistence.dao.db.jpa.repository;

import com.bs24.demo.persistence.dao.db.jpa.entity.ExerciseTypeJPA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseTypeJPARepository extends JpaRepository<ExerciseTypeJPA, Long> {
}

package com.bs24.demo.domain.repository;

import com.bs24.demo.domain.model.ExerciseSubtype;

import java.util.Optional;

public interface ExerciseSubtypeRepository {
    Optional<ExerciseSubtype> findById(int id);
}

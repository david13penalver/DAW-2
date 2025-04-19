package com.bs24.demo.domain.repository;

import com.bs24.demo.domain.model.ExerciseType;

import java.util.Optional;

public interface ExerciseTypeRepository {

    Optional<ExerciseType> findById(int exerciseTypeId);
}

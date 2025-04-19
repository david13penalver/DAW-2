package com.bs24.demo.domain.service;

import com.bs24.demo.domain.model.ExerciseType;

import java.util.Optional;

public interface ExerciseTypeService {
    Optional<ExerciseType> findById(int exerciseTypeId);
}

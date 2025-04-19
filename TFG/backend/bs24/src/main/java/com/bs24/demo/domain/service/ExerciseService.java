package com.bs24.demo.domain.service;

import com.bs24.demo.domain.model.Exercise;
import com.bs24.demo.domain.model.ListWithCount;

import java.util.Optional;

public interface ExerciseService {
    ListWithCount<Exercise> getAll(int page, int pageSize);

    Optional<Exercise> findById(int exerciseId);

    void save(Exercise exercise);
}

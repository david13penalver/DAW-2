package com.bs24.demo.domain.repository;

import com.bs24.demo.domain.model.Exercise;
import com.bs24.demo.domain.model.ListWithCount;

public interface ExerciseRepository {
    ListWithCount<Exercise> getAll(int page, int pageSize);
}

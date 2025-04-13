package com.bs24.demo.domain.service;

import com.bs24.demo.domain.model.Exercise;
import com.bs24.demo.domain.model.ListWithCount;

public interface ExerciseService {
    ListWithCount<Exercise> getAll(int page, int pageSize);
}

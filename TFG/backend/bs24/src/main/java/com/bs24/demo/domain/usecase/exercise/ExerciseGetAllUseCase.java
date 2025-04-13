package com.bs24.demo.domain.usecase.exercise;

import com.bs24.demo.domain.model.Exercise;
import com.bs24.demo.domain.model.ListWithCount;

public interface ExerciseGetAllUseCase {
    ListWithCount<Exercise> execute(int page, int pageSize);
}

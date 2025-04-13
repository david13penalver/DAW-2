package com.bs24.demo.domain.usecase.exercise;

import com.bs24.demo.domain.model.Exercise;

public interface ExerciseFindByIdUseCase {
    Exercise execute(int exerciseId);
}

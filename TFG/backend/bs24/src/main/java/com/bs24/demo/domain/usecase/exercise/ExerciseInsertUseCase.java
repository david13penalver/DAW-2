package com.bs24.demo.domain.usecase.exercise;

import com.bs24.demo.controller.user.webmodel.ExerciseDetail;
import com.bs24.demo.domain.model.Exercise;

public interface ExerciseInsertUseCase {
    void execute(Exercise exercise);
}

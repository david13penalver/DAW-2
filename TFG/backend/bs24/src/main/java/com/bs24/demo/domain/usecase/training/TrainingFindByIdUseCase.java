package com.bs24.demo.domain.usecase.training;

import com.bs24.demo.domain.model.Training;

public interface TrainingFindByIdUseCase {
    Training execute(int trainingId);
}

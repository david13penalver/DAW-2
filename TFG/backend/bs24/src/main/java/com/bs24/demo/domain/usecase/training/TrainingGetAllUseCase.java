package com.bs24.demo.domain.usecase.training;

import com.bs24.demo.domain.model.ListWithCount;
import com.bs24.demo.domain.model.Session;
import com.bs24.demo.domain.model.Training;

public interface TrainingGetAllUseCase {
    ListWithCount<Training> execute(int page, int pageSize);
}

package com.bs24.demo.domain.repository;

import com.bs24.demo.domain.model.ListWithCount;
import com.bs24.demo.domain.model.Training;

import java.util.Optional;

public interface TrainingRepository {
    Optional<Training> findById(int trainingId);

    ListWithCount<Training> getAll(int page, int pageSize);

    void save(Training training);
}

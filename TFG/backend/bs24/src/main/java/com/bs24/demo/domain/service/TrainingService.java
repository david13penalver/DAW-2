package com.bs24.demo.domain.service;

import com.bs24.demo.domain.model.ListWithCount;
import com.bs24.demo.domain.model.Training;

import java.util.Optional;

public interface TrainingService {
    Optional<Training> findById(int trainingId);

    ListWithCount<Training> getAll(int page, int pageSize);

    void save(Training training);

    void delete(int id);
}

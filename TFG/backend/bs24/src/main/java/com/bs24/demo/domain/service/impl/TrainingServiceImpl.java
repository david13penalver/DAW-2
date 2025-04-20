package com.bs24.demo.domain.service.impl;

import com.bs24.demo.common.annotation.DomainService;
import com.bs24.demo.domain.model.ListWithCount;
import com.bs24.demo.domain.model.Training;
import com.bs24.demo.domain.repository.TrainingRepository;
import com.bs24.demo.domain.service.TrainingService;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@DomainService
@RequiredArgsConstructor
public class TrainingServiceImpl implements TrainingService {

    private final TrainingRepository trainingRepository;

    @Override
    public Optional<Training> findById(int trainingId) {
        return trainingRepository.findById(trainingId);
    }

    @Override
    public ListWithCount<Training> getAll(int page, int pageSize) {
        return trainingRepository.getAll(page, pageSize);
    }

    @Override
    public void save(Training training) {
        trainingRepository.save(training);
    }

    @Override
    public void delete(int id) {
        trainingRepository.delete(id);
    }
}

package com.bs24.demo.domain.service.impl;

import com.bs24.demo.common.annotation.DomainService;
import com.bs24.demo.domain.model.Exercise;
import com.bs24.demo.domain.model.ListWithCount;
import com.bs24.demo.domain.repository.ExerciseRepository;
import com.bs24.demo.domain.service.ExerciseService;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@DomainService
@RequiredArgsConstructor
public class ExerciseServiceImpl implements ExerciseService {

    private final ExerciseRepository exerciseRepository;
    @Override
    public ListWithCount<Exercise> getAll(int page, int pageSize) {
        return exerciseRepository.getAll(page, pageSize);
    }

    @Override
    public Optional<Exercise> findById(int exerciseId) {
        return exerciseRepository.findById(exerciseId);
    }
}

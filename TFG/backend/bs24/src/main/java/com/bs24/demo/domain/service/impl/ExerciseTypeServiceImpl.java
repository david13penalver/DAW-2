package com.bs24.demo.domain.service.impl;

import com.bs24.demo.common.annotation.DomainService;
import com.bs24.demo.domain.model.ExerciseType;
import com.bs24.demo.domain.repository.ExerciseTypeRepository;
import com.bs24.demo.domain.service.ExerciseTypeService;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@DomainService
@RequiredArgsConstructor
public class ExerciseTypeServiceImpl implements ExerciseTypeService {

    private final ExerciseTypeRepository exerciseTypeRepository;

    @Override
    public Optional<ExerciseType> findById(int exerciseTypeId) {
        return exerciseTypeRepository.findById(exerciseTypeId);
    }
}

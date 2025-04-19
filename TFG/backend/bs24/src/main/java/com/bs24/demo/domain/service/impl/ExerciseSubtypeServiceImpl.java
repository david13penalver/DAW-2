package com.bs24.demo.domain.service.impl;

import com.bs24.demo.common.annotation.DomainService;
import com.bs24.demo.domain.model.ExerciseSubtype;
import com.bs24.demo.domain.repository.ExerciseSubtypeRepository;
import com.bs24.demo.domain.service.ExerciseSubtypeService;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@DomainService
@RequiredArgsConstructor
public class ExerciseSubtypeServiceImpl implements ExerciseSubtypeService {

    private final ExerciseSubtypeRepository exerciseSubtypeRepository;

    @Override
    public Optional<ExerciseSubtype> findById(int id) {
        return exerciseSubtypeRepository.findById(id);
    }
}

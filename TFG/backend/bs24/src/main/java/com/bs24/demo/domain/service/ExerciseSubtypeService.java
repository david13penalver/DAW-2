package com.bs24.demo.domain.service;

import com.bs24.demo.domain.model.ExerciseSubtype;

import java.util.Optional;

public interface ExerciseSubtypeService {

    Optional<ExerciseSubtype> findById(int id);
}

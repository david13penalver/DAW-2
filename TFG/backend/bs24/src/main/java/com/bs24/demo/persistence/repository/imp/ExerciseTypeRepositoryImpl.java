package com.bs24.demo.persistence.repository.imp;

import com.bs24.demo.domain.model.ExerciseType;
import com.bs24.demo.domain.repository.ExerciseTypeRepository;
import com.bs24.demo.persistence.dao.db.ExerciseTypeDaoDb;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ExerciseTypeRepositoryImpl implements ExerciseTypeRepository {

    private final ExerciseTypeDaoDb exerciseTypeDaoDb;

    @Override
    public Optional<ExerciseType> findById(int exerciseTypeId) {
        return exerciseTypeDaoDb.findById(exerciseTypeId);
    }
}

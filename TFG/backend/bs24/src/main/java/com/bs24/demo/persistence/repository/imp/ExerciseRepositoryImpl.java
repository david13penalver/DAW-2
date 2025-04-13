package com.bs24.demo.persistence.repository.imp;

import com.bs24.demo.domain.model.Exercise;
import com.bs24.demo.domain.model.ListWithCount;
import com.bs24.demo.domain.repository.ExerciseRepository;
import com.bs24.demo.persistence.dao.db.ExerciseDaoDb;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ExerciseRepositoryImpl implements ExerciseRepository {

    private final ExerciseDaoDb exerciseDaoDb;
    @Override
    public ListWithCount<Exercise> getAll(int page, int pageSize) {
        return exerciseDaoDb.getAll(page, pageSize);
    }

    @Override
    public Optional<Exercise> findById(int exerciseId) {
        return exerciseDaoDb.findById(exerciseId);
    }
}

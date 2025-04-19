package com.bs24.demo.persistence.repository.imp;

import com.bs24.demo.domain.model.ExerciseSubtype;
import com.bs24.demo.domain.repository.ExerciseSubtypeRepository;
import com.bs24.demo.persistence.dao.db.ExerciseSubtypeDaoDb;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ExerciseSubtypeRepositoryImpl implements ExerciseSubtypeRepository {

    private final ExerciseSubtypeDaoDb exerciseSubtypeDaoDb;
    @Override
    public Optional<ExerciseSubtype> findById(int id) {
        return exerciseSubtypeDaoDb.findById(id);
    }
}

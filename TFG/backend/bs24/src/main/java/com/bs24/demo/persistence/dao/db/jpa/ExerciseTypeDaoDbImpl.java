package com.bs24.demo.persistence.dao.db.jpa;

import com.bs24.demo.domain.model.ExerciseType;
import com.bs24.demo.domain.model.ListWithCount;
import com.bs24.demo.persistence.dao.db.ExerciseTypeDaoDb;
import com.bs24.demo.persistence.dao.db.jpa.mapper.ExerciseTypeJPAMapper;
import com.bs24.demo.persistence.dao.db.jpa.repository.ExerciseTypeJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ExerciseTypeDaoDbImpl implements ExerciseTypeDaoDb {

    private final ExerciseTypeJPARepository exerciseTypeJPARepository;

    @Override
    public List<ExerciseType> getAll() {
        return List.of();
    }

    @Override
    public ListWithCount<ExerciseType> getAll(int page, int size) {
        return null;
    }

    @Override
    public Optional<ExerciseType> findById(long id) {
        return exerciseTypeJPARepository.findById(id)
                .map(ExerciseTypeJPAMapper.INSTANCE::toExerciseType);
    }

    @Override
    public long insert(ExerciseType exerciseType) {
        return 0;
    }

    @Override
    public void update(ExerciseType exerciseType) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public ExerciseType save(ExerciseType exerciseType) {
        return null;
    }
}

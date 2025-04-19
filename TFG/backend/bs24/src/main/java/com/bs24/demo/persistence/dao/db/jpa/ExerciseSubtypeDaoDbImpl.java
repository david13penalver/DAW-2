package com.bs24.demo.persistence.dao.db.jpa;

import com.bs24.demo.domain.model.ExerciseSubtype;
import com.bs24.demo.domain.model.ListWithCount;
import com.bs24.demo.persistence.dao.db.ExerciseSubtypeDaoDb;
import com.bs24.demo.persistence.dao.db.jpa.mapper.ExerciseSubtypeJPAMapper;
import com.bs24.demo.persistence.dao.db.jpa.repository.ExerciseSubtypeJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ExerciseSubtypeDaoDbImpl implements ExerciseSubtypeDaoDb {

    private final ExerciseSubtypeJPARepository exerciseSubtypeJPARepository;

    @Override
    public List<ExerciseSubtype> getAll() {
        return List.of();
    }

    @Override
    public ListWithCount<ExerciseSubtype> getAll(int page, int size) {
        return null;
    }

    @Override
    public Optional<ExerciseSubtype> findById(long id) {
        return exerciseSubtypeJPARepository.findById(id)
                .map(ExerciseSubtypeJPAMapper.INSTANCE::toExerciseSubtype);
    }

    @Override
    public long insert(ExerciseSubtype exerciseSubtype) {
        return 0;
    }

    @Override
    public void update(ExerciseSubtype exerciseSubtype) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public ExerciseSubtype save(ExerciseSubtype exerciseSubtype) {
        return null;
    }
}

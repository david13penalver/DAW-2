package com.bs24.demo.persistence.dao.db.jpa;

import com.bs24.demo.domain.model.Exercise;
import com.bs24.demo.domain.model.ListWithCount;
import com.bs24.demo.persistence.dao.db.ExerciseDaoDb;
import com.bs24.demo.persistence.dao.db.jpa.entity.ExerciseJPA;
import com.bs24.demo.persistence.dao.db.jpa.mapper.ExerciseJPAMapper;
import com.bs24.demo.persistence.dao.db.jpa.repository.ExerciseJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ExerciseDaoDbImpl implements ExerciseDaoDb {

    private final ExerciseJPARepository exerciseJPARepository;

    @Override
    public List<Exercise> getAll() {
        return List.of();
    }

    @Override
    public ListWithCount<Exercise> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ExerciseJPA> exerciseJPAPage = exerciseJPARepository.findAll(pageable);
        return new ListWithCount<>(
                exerciseJPAPage.stream()
                        .map(ExerciseJPAMapper.INSTANCE::toExercise)
                        .toList(),
                exerciseJPAPage.getTotalElements()
        );

    }

    @Override
    public Optional<Exercise> findById(long id) {
        return exerciseJPARepository.findById(id)
                .map(ExerciseJPAMapper.INSTANCE::toExercise);
    }

    @Override
    public long insert(Exercise exercise) {
        return 0;
    }

    @Override
    public void update(Exercise exercise) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public Exercise save(Exercise exercise) {
        ExerciseJPA exerciseJPA = ExerciseJPAMapper.INSTANCE.toExerciseJPA(exercise);
        return ExerciseJPAMapper.INSTANCE.toExercise(exerciseJPARepository.save(exerciseJPA));
    }
}

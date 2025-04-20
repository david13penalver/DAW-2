package com.bs24.demo.persistence.dao.db.jpa;

import com.bs24.demo.domain.model.ListWithCount;
import com.bs24.demo.domain.model.Training;
import com.bs24.demo.persistence.dao.db.TrainingDaoDb;
import com.bs24.demo.persistence.dao.db.jpa.entity.ExerciseJPA;
import com.bs24.demo.persistence.dao.db.jpa.entity.TrainingJPA;
import com.bs24.demo.persistence.dao.db.jpa.mapper.ExerciseJPAMapper;
import com.bs24.demo.persistence.dao.db.jpa.mapper.TrainingJPAMapper;
import com.bs24.demo.persistence.dao.db.jpa.repository.TrainingJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TrainingDaoDbImpl implements TrainingDaoDb {

    private final TrainingJPARepository trainingJPARepository;

    @Override
    public List<Training> getAll() {
        return List.of();
    }

    @Override
    public ListWithCount<Training> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<TrainingJPA> trainingJPAPage = trainingJPARepository.findAll(pageable);
        return new ListWithCount<>(
                trainingJPAPage.stream()
                        .map(TrainingJPAMapper.INSTANCE::toTraining)
                        .toList(),
                trainingJPAPage.getTotalElements()
        );
    }

    @Override
    public Optional<Training> findById(long id) {
        return trainingJPARepository.findById(id)
                .map(TrainingJPAMapper.INSTANCE::toTraining);
    }

    @Override
    public long insert(Training training) {
        return 0;
    }

    @Override
    public void update(Training training) {

    }

    @Override
    public void delete(long id) {
        trainingJPARepository.deleteById(id);
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public Training save(Training training) {
        TrainingJPA trainingJPA = TrainingJPAMapper.INSTANCE.toTrainingJPA(training);
        return TrainingJPAMapper.INSTANCE.toTraining(trainingJPARepository.save(trainingJPA));
    }
}

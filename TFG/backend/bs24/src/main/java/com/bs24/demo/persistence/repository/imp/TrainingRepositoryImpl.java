package com.bs24.demo.persistence.repository.imp;

import com.bs24.demo.domain.model.ListWithCount;
import com.bs24.demo.domain.model.Training;
import com.bs24.demo.domain.repository.TrainingRepository;
import com.bs24.demo.persistence.dao.db.TrainingDaoDb;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TrainingRepositoryImpl implements TrainingRepository {

    private final TrainingDaoDb trainingDaoDb;

    @Override
    public Optional<Training> findById(int trainingId) {
        return trainingDaoDb.findById(trainingId);
    }

    @Override
    public ListWithCount<Training> getAll(int page, int pageSize) {
        return trainingDaoDb.getAll(page, pageSize);
    }

    @Override
    public void save(Training training) {
        trainingDaoDb.save(training);
    }
}

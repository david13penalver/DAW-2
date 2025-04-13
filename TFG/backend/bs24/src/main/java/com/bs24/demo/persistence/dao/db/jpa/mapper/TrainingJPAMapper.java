package com.bs24.demo.persistence.dao.db.jpa.mapper;

import com.bs24.demo.domain.model.Training;
import com.bs24.demo.persistence.dao.db.jpa.entity.TrainingJPA;
import org.mapstruct.Mapper;

@Mapper
public interface TrainingJPAMapper {

    TrainingJPAMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(TrainingJPAMapper.class);

    Training toTraining(TrainingJPA trainingJPA);
    TrainingJPA toTrainingJPA(Training training);
}

package com.bs24.demo.controller.user.webmodel;

import com.bs24.demo.domain.model.Session;
import com.bs24.demo.domain.model.Training;
import org.mapstruct.Mapper;

@Mapper(uses = {UserDetailMapper.class})
public interface TrainingDetailMapper {

    TrainingDetailMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(TrainingDetailMapper.class);

    TrainingDetail toTrainingDetail(Training training);

    Training toTraining(TrainingDetail trainingDetail);

}

package com.bs24.demo.controller.user.webmodel;

import com.bs24.demo.domain.model.Session;
import com.bs24.demo.domain.model.Training;
import org.mapstruct.Mapper;

@Mapper(uses = {UserDetailMapper.class})
public interface TrainingCollectionMapper {

    TrainingCollectionMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(TrainingCollectionMapper.class);

    TrainingCollecion toTrainingCollection(Training training);

    Training toTraining(TrainingCollecion trainingCollecion);

}

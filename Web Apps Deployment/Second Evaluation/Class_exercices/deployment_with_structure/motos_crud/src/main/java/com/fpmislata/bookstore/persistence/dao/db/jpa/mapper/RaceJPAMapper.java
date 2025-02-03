package com.fpmislata.bookstore.persistence.dao.db.jpa.mapper;

import com.fpmislata.bookstore.domain.model.Race;
import com.fpmislata.bookstore.persistence.dao.db.jpa.entity.RaceJPA;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RaceJPAMapper {

    RaceJPAMapper INSTANCE = Mappers.getMapper(RaceJPAMapper.class);

    Race toRace(RaceJPA raceJPA);

    RaceJPA toRaceJPA(Race race);
}

package com.fpmislata.bookstore.persistence.dao.db.jpa.mapper;

import com.fpmislata.bookstore.domain.model.Team;
import com.fpmislata.bookstore.persistence.dao.db.jpa.entity.TeamJPA;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TeamJPAMapper {

    TeamJPAMapper INSTANCE = Mappers.getMapper(TeamJPAMapper.class);

    Team toTeam(TeamJPA teamJPA);

    TeamJPA toTeamJPA(Team team);
}

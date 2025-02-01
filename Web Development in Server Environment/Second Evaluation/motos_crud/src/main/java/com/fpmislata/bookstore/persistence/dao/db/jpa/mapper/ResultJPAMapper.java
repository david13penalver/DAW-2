package com.fpmislata.bookstore.persistence.dao.db.jpa.mapper;

import com.fpmislata.bookstore.domain.model.Result;
import com.fpmislata.bookstore.persistence.dao.db.jpa.entity.ResultJPA;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ResultJPAMapper {

    ResultJPAMapper INSTANCE = Mappers.getMapper(ResultJPAMapper.class);

    Result toResult(ResultJPA resultJPA);

    ResultJPA toResultJPA(Result result);
}

package com.fpmislata.bookstore.persistence.dao.db.jpa.mapper;

import com.fpmislata.bookstore.domain.model.Bike;
import com.fpmislata.bookstore.persistence.dao.db.jpa.entity.BikeJPA;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {RiderJPAMapper.class})
public interface BikeJPAMapper {

    BikeJPAMapper INSTANCE = Mappers.getMapper(BikeJPAMapper.class);

    Bike toBike(BikeJPA bikeJPA);

    BikeJPA toBikeJPA(Bike bike);
}

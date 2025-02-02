package com.fpmislata.bookstore.persistence.dao.db.jpa.mapper;

import com.fpmislata.bookstore.domain.model.Rider;
import com.fpmislata.bookstore.persistence.dao.db.jpa.entity.RiderJPA;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {TeamJPAMapper.class})
public interface RiderJPAMapper {

    RiderJPAMapper INSTANCE = Mappers.getMapper(RiderJPAMapper.class);

    Rider toRider(RiderJPA riderJPA);

    RiderJPA toRiderJPA(Rider rider);
}

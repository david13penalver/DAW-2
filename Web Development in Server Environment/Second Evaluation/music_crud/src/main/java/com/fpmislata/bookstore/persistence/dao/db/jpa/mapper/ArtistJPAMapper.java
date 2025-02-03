package com.fpmislata.bookstore.persistence.dao.db.jpa.mapper;

import com.fpmislata.bookstore.domain.model.Artist;
import com.fpmislata.bookstore.persistence.dao.db.jpa.entity.ArtistJPA;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ArtistJPAMapper {

    ArtistJPAMapper INSTANCE = Mappers.getMapper(ArtistJPAMapper.class);

    ArtistJPA toArtistJPA(Artist artist);

    Artist toArtist(ArtistJPA artistJPA);
}

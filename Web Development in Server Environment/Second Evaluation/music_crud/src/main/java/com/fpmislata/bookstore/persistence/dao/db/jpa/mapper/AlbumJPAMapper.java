package com.fpmislata.bookstore.persistence.dao.db.jpa.mapper;

import com.fpmislata.bookstore.domain.model.Album;
import com.fpmislata.bookstore.persistence.dao.db.jpa.entity.AlbumJPA;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {ArtistJPAMapper.class, SongJPAMapper.class})
public interface AlbumJPAMapper {

    AlbumJPAMapper INSTANCE = Mappers.getMapper(AlbumJPAMapper.class);

    Album toAlbum(AlbumJPA albumJPA);

    AlbumJPA toAlbumJPA(Album album);
}

package com.fpmislata.bookstore.persistence.dao.db.jpa.mapper;

import com.fpmislata.bookstore.domain.model.Song;
import com.fpmislata.bookstore.persistence.dao.db.jpa.entity.SongJPA;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import static org.mapstruct.factory.Mappers.*;

@Mapper(uses = {AlbumJPAMapper.class})
public interface SongJPAMapper {

    SongJPAMapper INSTANCE = Mappers.getMapper(SongJPAMapper.class);

    SongJPA toSongJPA(Song song);

    Song toSong(SongJPA songJPA);
}

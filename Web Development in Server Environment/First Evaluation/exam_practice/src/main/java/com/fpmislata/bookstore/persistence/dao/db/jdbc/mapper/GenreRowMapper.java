package com.fpmislata.bookstore.persistence.dao.db.jdbc.mapper;

import com.fpmislata.bookstore.domain.model.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GenreRowMapper implements CustomRowMapper{
    @Override
    public Genre mapRow(ResultSet rs, int rowNum) throws SQLException {
        Genre genre = new Genre();
        genre.setId(rs.getLong("genres.id"));
        genre.setNameEs(rs.getString("genres.name_es"));
        genre.setNameEn(rs.getString("genres.name_es"));
        genre.setSlug(rs.getString("genres.slug"));
        return genre;
    }
}

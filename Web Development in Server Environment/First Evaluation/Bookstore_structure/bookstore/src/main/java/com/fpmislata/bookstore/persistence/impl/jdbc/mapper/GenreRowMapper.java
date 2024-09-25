package com.fpmislata.bookstore.persistence.impl.jdbc.mapper;

import com.fpmislata.bookstore.domain.model.Genre;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GenreRowMapper implements RowMapper<Genre> {

    @Override
    public Genre mapRow(ResultSet rs, int rowNum) throws SQLException {
        Genre genre = new Genre();
        genre.setId(rs.getInt("genres.id"));
        genre.setName(rs.getString("genres.name_es"));
        genre.setSlug(rs.getString("genres.slug"));
        return genre;
    }
}

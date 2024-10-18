package com.fpmislata.bookstore.persistence.user.jdbc.mapper;

import com.fpmislata.bookstore.common.locale.LanguageUtils;
import com.fpmislata.bookstore.domain.user.model.Genre;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GenreRowMapper implements RowMapper<Genre> {

    @Override
    public Genre mapRow(ResultSet rs, int rowNum) throws SQLException {
        String language = LanguageUtils.getCurrentLanguage();
        Genre genre = new Genre();
        genre.setId(rs.getInt("genres.id"));
        genre.setName(rs.getString("genres.name_" + language));
        genre.setSlug(rs.getString("genres.slug"));
        return genre;
    }
}

package com.fpmislata.bookstore.persistence.impl.jdbc.mapper;


import com.fpmislata.bookstore.common.locale.LanguageUtils;
import com.fpmislata.bookstore.domain.model.Author;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorRowMapper implements RowMapper<Author> {

    @Override
    public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
        String language = LanguageUtils.getCurrentLanguage();
        Author author = new Author();
        author.setId(rs.getInt("authors.id"));
        author.setName(rs.getString("authors.name"));
        author.setNationality(rs.getString("authors.nationality"));
        author.setBiography(rs.getString("authors.biography_" + language));
        author.setBirthYear(rs.getInt("authors.birth_year"));
        author.setDeathYear(rs.getInt("authors.death_year"));
        return author;
    }
}
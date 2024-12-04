package com.fpmislata.bookstore.persistence.dao.db.jdbc.mapper;

import com.fpmislata.bookstore.common.locale.LanguageUtils;
import com.fpmislata.bookstore.domain.model.Author;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorRowMapper implements CustomRowMapper<Author> {
    @Override
    public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
        Author author = new Author();
        author.setId(rs.getLong("authors.id"));
        author.setName(rs.getString("authors.name"));
        author.setNationality(rs.getString("authors.nationality"));
        author.setBiographyEs(rs.getString("authors.biography_es"));
        author.setBiographyEn(rs.getString("authors.biography_en"));
        author.setBirthYear(rs.getInt("authors.birth_year"));
        author.setDeathYear(rs.getInt("authors.death_year"));

        return author;
    }
}

package com.fpmislata.bookstore.persistence.impl.jdbc.mapper;


import com.fpmislata.bookstore.domain.model.Author;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorRowMapper implements RowMapper<Author> {

    @Override
    public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
        Author author = new Author();
        author.setId(rs.getInt("authors.id"));
        author.setName(rs.getString("authors.name"));
        author.setNationality(rs.getString("authors.nationality_es"));
        author.setBiography(rs.getString("authors.biography_es"));
        author.setBirthYear(rs.getInt("authors.birth_year"));
        author.setDeathYear(rs.getInt("authors.death_year"));
        return author;
    }
}
package com.fpmislata.bookstore.persistence.dao.db.jdbc.mapper;

import com.fpmislata.bookstore.domain.model.Director;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DirectorRowMapper implements CustomRowMapper<Director> {
    @Override
    public Director mapRow(ResultSet rs, int rowNum) throws SQLException {
        Director director = new Director();
        director.setId(rs.getString("directors.imdb_id"));
        director.setName(rs.getString("directors.name"));
        director.setBirthYear(rs.getInt("directors.birthYear"));
        director.setDeathYear(rs.getInt("directors.deathYear"));
        return director;
    }
}

package com.fpmislata.bookstore.persistence.dao.db.jdbc.mapper;

import com.fpmislata.bookstore.domain.model.Movie;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieRowMapper implements CustomRowMapper<Movie> {
    @Override
    public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
        Movie movie = new Movie();
        movie.setId(rs.getInt("movies.imdb_id"));
        movie.setTitle(rs.getString("movies.title"));
        movie.setYear(rs.getInt("movies.year"));
        if (this.existsColumn(rs, "movies.director_id"))
        return movie;
    }
}

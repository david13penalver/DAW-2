package com.fpmislata.bookstore.persistence.dao.impl.jdbc;

import com.fpmislata.bookstore.domain.model.CharacterComic;
import com.fpmislata.bookstore.persistence.dao.CharacterDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class CharacterDaoJdbc implements CharacterDao {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<CharacterComic> getAll() {
        String sql = "SELECT * FROM characters";
        return jdbcTemplate.query(sql, new CharacterComicRowMapper());
    }
}

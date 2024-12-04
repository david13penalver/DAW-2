package com.fpmislata.bookstore.persistence.dao.db.jdbc;

import com.fpmislata.bookstore.domain.model.User;
import com.fpmislata.bookstore.persistence.dao.db.UserDaoDb;
import com.fpmislata.bookstore.persistence.dao.db.jdbc.mapper.UserRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDaoJdbcImpl implements UserDaoDb {
    private final JdbcTemplate jdbcTemplate;
    @Override
    public User getByIdBook(Long id) {
        String sql = """
                SELECT users.*
                FROM users
                JOIN orders ON users.id = orders.user_id
                WHERE users.id = ?;
                
           """;
        return jdbcTemplate.queryForObject(sql, new UserRowMapper(), id);
    }
}

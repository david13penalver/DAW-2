package com.fpmislata.bookstore.persistence.dao.db.jdbc.mapper;

import com.fpmislata.bookstore.domain.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements CustomRowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        User user = new User();
        user.setId(resultSet.getLong("users.id"));
        user.setName(resultSet.getString("users.name"));
        user.setAddress(resultSet.getString("users.address"));
        user.setAdmin(resultSet.getBoolean("users.admin"));
        return user;
    }
}

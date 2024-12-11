package com.fpmislata.bookstore.persistence.dao.db.jdbc.mapper;

import com.fpmislata.bookstore.common.locale.LanguageUtils;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface CustomRowMapper<T> extends RowMapper<T> {

    default boolean existsColumn(ResultSet rs, String columnName) {
        try {
            rs.findColumn(columnName);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    default String getLanguage() {
        return LanguageUtils.getCurrentLanguage();
    }
}

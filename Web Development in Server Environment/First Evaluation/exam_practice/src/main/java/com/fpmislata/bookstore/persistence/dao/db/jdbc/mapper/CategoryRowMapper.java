package com.fpmislata.bookstore.persistence.dao.db.jdbc.mapper;

import com.fpmislata.bookstore.domain.model.Category;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryRowMapper implements CustomRowMapper<Category>{
    @Override
    public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
        Category category = new Category();
        category.setId(rs.getLong("categories.id"));
        category.setNameEs(rs.getString("categories.name_es"));
        category.setNameEn(rs.getString("categories.name_en"));
        category.setSlug(rs.getString("categories.slug"));

        return category;
    }
}

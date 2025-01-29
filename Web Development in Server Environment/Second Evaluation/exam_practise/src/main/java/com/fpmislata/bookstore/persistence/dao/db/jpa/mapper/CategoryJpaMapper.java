package com.fpmislata.bookstore.persistence.dao.db.jpa.mapper;

import com.fpmislata.bookstore.domain.model.Category;
import com.fpmislata.bookstore.persistence.dao.db.jpa.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryJpaMapper {

    CategoryJpaMapper INSTANCE = Mappers.getMapper(CategoryJpaMapper.class);

    CategoryEntity toCategoryEntity(Category category);

    Category toCategory(CategoryEntity categoryEntity);
}

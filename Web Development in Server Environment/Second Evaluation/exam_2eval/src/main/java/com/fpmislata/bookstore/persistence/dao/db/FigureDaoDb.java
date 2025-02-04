package com.fpmislata.bookstore.persistence.dao.db;

import com.fpmislata.bookstore.domain.model.Figure;

import java.util.List;

public interface FigureDaoDb extends GenericDaoDb<Figure> {
    List<Figure> findAllById(Long[] ids);
}

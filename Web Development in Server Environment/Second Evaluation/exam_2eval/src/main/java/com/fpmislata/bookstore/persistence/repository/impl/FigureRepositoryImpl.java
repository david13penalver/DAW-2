package com.fpmislata.bookstore.persistence.repository.impl;

import com.fpmislata.bookstore.domain.model.Figure;
import com.fpmislata.bookstore.domain.repository.FigureRepository;
import com.fpmislata.bookstore.persistence.dao.db.FigureDaoDb;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FigureRepositoryImpl implements FigureRepository {

    private final FigureDaoDb figureDaoDb;

    @Override
    public List<Figure> findAllById(Long[] ids) {
        return figureDaoDb.findAllById(ids);
    }
}

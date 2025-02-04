package com.fpmislata.bookstore.domain.repository;

import com.fpmislata.bookstore.domain.model.Figure;

import java.util.List;

public interface FigureRepository {
    List<Figure> findAllById(Long[] array);
}

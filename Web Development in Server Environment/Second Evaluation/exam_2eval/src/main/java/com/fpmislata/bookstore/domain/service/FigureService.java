package com.fpmislata.bookstore.domain.service;

import com.fpmislata.bookstore.domain.model.Figure;

import java.util.List;

public interface FigureService {
    List<Figure> findAllById(List<Figure> figures);
}

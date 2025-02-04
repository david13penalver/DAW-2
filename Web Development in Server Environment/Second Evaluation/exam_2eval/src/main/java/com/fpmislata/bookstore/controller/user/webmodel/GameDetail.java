package com.fpmislata.bookstore.controller.user.webmodel;

import com.fpmislata.bookstore.domain.model.Director;
import com.fpmislata.bookstore.domain.model.Figure;

import java.util.List;

public record GameDetail(
        String gameCode,
        String title,
        Long releaseYear,
        String description,
        DirectorDetail director,
        List<FigureDetail>figures
) {
}

package com.fpmislata.bookstore.controller.common.webmodel.book;

import com.fpmislata.bookstore.domain.model.Director;

public record MovieCollection(
        String title,
        Integer year,
        Director director
) {
}


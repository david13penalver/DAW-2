package com.fpmislata.bookstore.controller.user.webmodel.book;

import com.fpmislata.bookstore.domain.model.Author;

import java.util.List;

public record BookDetail(
        String isbn,
        String title,
        String synopsis,
        Long price,
        Long discount,
        String publisher,
        String category,
        List<Author> authors
) {
}

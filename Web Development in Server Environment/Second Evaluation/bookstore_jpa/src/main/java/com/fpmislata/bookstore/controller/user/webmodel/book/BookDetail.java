package com.fpmislata.bookstore.controller.user.webmodel.book;

import com.fpmislata.bookstore.controller.user.webmodel.author.AuthorCollection;
import com.fpmislata.bookstore.controller.user.webmodel.publisher.PublisherCollection;

import java.math.BigDecimal;
import java.util.List;

public record BookDetail(
        String isbn,
        String title,
        BigDecimal price,
        float discount,
        String synopsis,
        String cover,
        List<String> genres,
        String category,
        PublisherCollection publisher,
        List<AuthorCollection> authors
) {
}

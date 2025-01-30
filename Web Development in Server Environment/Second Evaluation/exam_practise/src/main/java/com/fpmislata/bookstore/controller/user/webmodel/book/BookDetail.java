package com.fpmislata.bookstore.controller.user.webmodel.book;

import com.fpmislata.bookstore.controller.user.webmodel.author.AuthorCollection;
import com.fpmislata.bookstore.controller.user.webmodel.author.AuthorName;
import com.fpmislata.bookstore.controller.user.webmodel.genre.GenreCollection;
import com.fpmislata.bookstore.controller.user.webmodel.publisher.PublisherDetail;
import com.fpmislata.bookstore.domain.model.Author;
import com.fpmislata.bookstore.domain.model.Genre;
import com.fpmislata.bookstore.domain.model.Publisher;

import java.util.List;

public record BookDetail(
        String isbn,
        String title,
        String synopsis,
        Long price,
        Long discount,
        String publisher,
        String category,
        List<AuthorName> authors,
        List<GenreCollection> genres
) {
}

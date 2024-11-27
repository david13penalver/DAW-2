package com.fpmislata.bookstore.controller.user.webmodel.book;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public record BookDetail(
        String isbn,
        String title,
        BigDecimal price,
        float discount,
        String synopsis,
        String cover,
        String category,
        @JsonProperty("publisher") PublisherCollection publisherCollection,
        @JsonProperty("authors") List<AuthorCollection> authorsCollection
) {
}

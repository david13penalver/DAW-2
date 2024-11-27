package com.fpmislata.bookstore.controller.user.webmodel.book;

import java.math.BigDecimal;

public record BookCollection(
        String isbn,
        String title,
        BigDecimal price,
        float discount,
        String cover
) {
}

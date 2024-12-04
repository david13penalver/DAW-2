package com.fpmislata.bookstore.controller.webmodel;

import java.math.BigDecimal;

public record OrderCollection(
        Long id,
        String orderDate,
        String deliveryDate,
        String status,
        BigDecimal total
) {
}

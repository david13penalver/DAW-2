package com.fpmislata.bookstore.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {

    private Long id;
    private int quantity;
    private BigDecimal price;
    private Book book;
}

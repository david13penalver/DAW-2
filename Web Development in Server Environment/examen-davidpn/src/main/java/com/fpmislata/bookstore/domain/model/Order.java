package com.fpmislata.bookstore.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private Long id;
    private String orderDate;
    private String deliveryDate;
    private String status;
    private BigDecimal total;
    private User user;
    private OrderDetail orderDetail;
}

package com.fpmislata.bookstore.persistence.dao.db.jdbc.mapper;

import com.fpmislata.bookstore.domain.model.OrderDetail;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDetailRowMapper implements CustomRowMapper<OrderDetail> {

    private final BookRowMapper bookMapper = new BookRowMapper();
    @Override
    public OrderDetail mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setId(resultSet.getLong("order_details.id"));
        orderDetail.setPrice(resultSet.getBigDecimal("order_details.price"));
        orderDetail.setQuantity(resultSet.getInt("order_details.quantity"));
        if(this.existsColumn(resultSet, "books.id")) {
            orderDetail.setBook(bookMapper.mapRow(resultSet, rowNum));
        }

        return orderDetail;
    }
}

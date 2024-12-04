package com.fpmislata.bookstore.persistence.dao.db.jdbc.mapper;

import com.fpmislata.bookstore.domain.model.Order;
import com.fpmislata.bookstore.domain.model.OrderDetail;
import com.fpmislata.bookstore.domain.model.User;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRowMapper implements CustomRowMapper<Order> {
    @Override
    public Order mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Order order = new Order();
        order.setId(resultSet.getLong("orders.id"));
        order.setOrderDate(resultSet.getString("orders.order_date"));
        order.setDeliveryDate(resultSet.getString("orders.delivery_date"));
        order.setStatus(resultSet.getString("orders.status"));
        order.setTotal(new BigDecimal(resultSet.getString("orders.total")));
        return order;
    }
}

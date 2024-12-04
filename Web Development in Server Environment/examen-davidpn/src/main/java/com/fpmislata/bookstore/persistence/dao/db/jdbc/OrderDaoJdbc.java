package com.fpmislata.bookstore.persistence.dao.db.jdbc;

import com.fpmislata.bookstore.domain.model.Order;
import com.fpmislata.bookstore.persistence.dao.db.OrderDaoDb;
import com.fpmislata.bookstore.persistence.dao.db.OrderDetailDaoDb;
import com.fpmislata.bookstore.persistence.dao.db.UserDaoDb;
import com.fpmislata.bookstore.persistence.dao.db.jdbc.mapper.OrderRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class OrderDaoJdbc implements OrderDaoDb {

    private final JdbcTemplate jdbcTemplate;
    private final UserDaoDb userDaoDb;
    private final OrderDetailDaoDb orderDetailDaoDb;

    @Override
    public List<Order> getAll(int size, int page) {
        String sql = """
                        SELECT * FROM orders
                        LIMIT ? OFFSET ?
                     """;

        // return jdbcTemplate.query(sql, new OrderRowMapper());
        return jdbcTemplate.query(sql, new OrderRowMapper(), size, page * size);
    }

    @Override
    public int count() {
        String sql = """
                        SELECT COUNT(*) FROM books
                     """;
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public Optional<Order> findById(Long id) {
        String sql = """
                SELECT *
                FROM orders
                LEFT JOIN users ON users.id = orders.user_id
                LEFT JOIN orders_details ON orders.id = orders_details.order_id
                WHERE orders.id = 1;
           """;
        try {
            Order order = jdbcTemplate.queryForObject(sql, new OrderRowMapper(), id);
            setUserAndOrderDetail(order);
            return Optional.of(order);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    private void setUserAndOrderDetail(Order order) {
        if(order!=null) {
            order.setUser(userDaoDb.getByIdBook(order.getId()));
            order.setOrderDetail(orderDetailDaoDb.getById(order.getId()));
        }
    }
}

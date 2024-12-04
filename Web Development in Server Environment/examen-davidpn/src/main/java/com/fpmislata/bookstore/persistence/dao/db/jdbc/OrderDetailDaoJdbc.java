package com.fpmislata.bookstore.persistence.dao.db.jdbc;

import com.fpmislata.bookstore.domain.model.Book;
import com.fpmislata.bookstore.domain.model.OrderDetail;
import com.fpmislata.bookstore.persistence.dao.db.OrderDetailDaoDb;
import com.fpmislata.bookstore.persistence.dao.db.jdbc.mapper.OrderDetailRowMapper;
import com.fpmislata.bookstore.persistence.dao.db.jdbc.mapper.UserRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class OrderDetailDaoJdbc implements OrderDetailDaoDb {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public OrderDetail getById(Long id) {
        String sql = """
                SELECT orders_details.* FROM orders_details
                JOIN orders ON orders_details WHERE orders.id = orders_details.order_id
                AND orders.id = ?
           """;
        return jdbcTemplate.queryForObject(sql, new OrderDetailRowMapper(), id);
    }

//    @Override
//    public OrderDetail addBook(Long idOrder, Optional<Book> book) {
//        String sql = """
//                INSERT INTO orders_details (order_id, book_id, quantity, price) VALUES (?, ?, ?, ?)
//           """;
//
//        return jdbcTemplate.queryForObject(sql, new OrderDetailRowMapper(), idOrder, book.get().getId(), 1, price());
//    }
}

package com.fpmislata.bookstore.persistence.dao.db.jdbc;

import com.fpmislata.bookstore.domain.model.Publisher;
import com.fpmislata.bookstore.persistence.dao.db.PublisherDaoDb;
import com.fpmislata.bookstore.persistence.dao.db.jdbc.mapper.PublisherRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PublisherDaoJdbc implements PublisherDaoDb {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Publisher> getAll() {
        return List.of();
    }

    @Override
    public List<Publisher> getAll(int page, int size) {
        return List.of();
    }

    @Override
    public Optional<Publisher> findById(long id) {
        String sql = """
                SELECT * FROM publishers
                WHERE id = ?
                """;
        try
        {
            return Optional.of(jdbcTemplate.queryForObject(sql, new PublisherRowMapper(), id));
        }
        catch (Exception e)
        {
            return Optional.empty();
        }
    }

    @Override
    public long insert(Publisher publisher) {
        return 0;
    }

    @Override
    public void update(Publisher publisher) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public void save(Publisher publisher) {

    }
}

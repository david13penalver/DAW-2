package com.fpmislata.bookstore.persistence.dao.db.jdbc;

import com.fpmislata.bookstore.common.exception.ResourceNotFoundException;
import com.fpmislata.bookstore.domain.model.Author;
import com.fpmislata.bookstore.domain.model.Book;
import com.fpmislata.bookstore.domain.model.Genre;
import com.fpmislata.bookstore.persistence.dao.db.AuthorDaoDb;
import com.fpmislata.bookstore.persistence.dao.db.BookDaoDb;
import com.fpmislata.bookstore.persistence.dao.db.GenericDaoDb;
import com.fpmislata.bookstore.persistence.dao.db.jdbc.mapper.BookRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BookDaoJdbc implements BookDaoDb {

    private final JdbcTemplate jdbcTemplate;
    private final AuthorDaoJdbc authorDaoJdbc;
    private final GenreDaoJdbc genreDaoJdbc;

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        String sql = """
                SELECT * FROM books
                LEFT JOIN categories ON books.category_id = categories.id
                LEFT JOIN publishers ON books.publisher_id = publishers.id
                WHERE books.isbn = ?
           """;
        try {
            Book book = jdbcTemplate.queryForObject(sql, new BookRowMapper(), isbn);
            setAuthorsAndGenres(book);
            return Optional.of(book);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    private void setAuthorsAndGenres(Book book) {
        if(book != null) {
            book.setAuthors(authorDaoJdbc.getByIdBook(book.getId()));
            book.setGenres(genreDaoJdbc.getByIdBook(book.getId()));
        }
    }

    @Override
    public List<Book> getAll() {
        String sql = """
                        SELECT * FROM books
                     """;
        return jdbcTemplate.query(sql, new BookRowMapper());
    }

    @Override
    public List<Book> getAll(int page, int size) {
        String sql = """
                        SELECT * FROM books
                        LIMIT ? OFFSET ?
                     """;
        return jdbcTemplate.query(sql, new BookRowMapper(), size, page * size);
    }

    @Override
    public Optional<Book> findById(long id) {
        String sql = """
                SELECT * FROM books
                LEFT JOIN categories ON books.category_id = categories.id
                LEFT JOIN publishers ON books.publisher_id = publishers.id
                WHERE books.id = ?
           """;
        try {
            Book book = jdbcTemplate.queryForObject(sql, new BookRowMapper(), id);
            setAuthorsAndGenres(book);
            return Optional.of(book);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public long insert(Book book) {
        String sql = """
                    INSERT INTO books(
                      isbn, 
                      title_es, 
                      title_en, 
                      synopsis_es, 
                      synopsis_en, 
                      price, 
                      discount, 
                      cover, 
                      publisher_id, 
                      category_id)
                    VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
                """;
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[] {"id"});
            ps.setString(1, book.getIsbn());
            ps.setString(2, book.getTitleEs());
            ps.setString(3, book.getTitleEn());
            ps.setString(4, book.getSynopsisEs());
            ps.setString(5, book.getSynopsisEn());
            ps.setBigDecimal(6, book.getPrice());
            ps.setFloat(7, book.getDiscount());
            ps.setString(8, book.getCover());
            ps.setLong(9, book.getPublisher().getId());
            ps.setLong(10, book.getCategory().getId());
            return ps;
        }, keyHolder);

        return keyHolder.getKey().longValue(); // Devuelve el ID generado

    }

    @Override
    public void update(Book book) {
        String sql = """
                    UPDATE books
                    SET isbn = ?,
                        title_es = ?,
                        title_en = ?,
                        synopsis_es = ?,
                        synopsis_en = ?,
                        price = ?,
                        discount = ?,
                        cover = ?,
                        publisher_id = ?,
                        category_id = ?
                    WHERE id = ?
                """;
        jdbcTemplate.update(
                sql,
                book.getIsbn(),
                book.getTitleEs(),
                book.getTitleEn(),
                book.getSynopsisEs(),
                book.getSynopsisEn(),
                book.getPrice(),
                book.getDiscount(),
                book.getCover(),
                book.getPublisher().getId(),
                book.getCategory().getId(),
                book.getId()
        );
    }

    @Override
    public void delete(long id) {
        this.deteleAuthors(id);
        this.deleteGenres(id);
        String sql = """
                    DELETE FROM books
                    WHERE id = ?
                """;
        jdbcTemplate.update(sql, id);
    }

    @Override
    public int count() {
        String sql = """
                        SELECT COUNT(*) FROM books
                     """;
        try {
            return jdbcTemplate.queryForObject(sql, Integer.class);
        } catch (ResourceNotFoundException e) {
            return -1;
        }
    }

    @Override
    public void save(Book book) {
        if(book.getId() != null) {
            this.update(book);
        } else {
            long id = this.insert(book);
            book.setId(id);
        }
        this.deteleAuthors(book.getId());
        this.insertAuthors(book.getId(), book.getAuthors());
        this.deleteGenres(book.getId());
        this.insertGenres(book.getId(), book.getGenres());
        //return book; Si queremos devolder a front el Book o el Id
    }

    @Override
    public void deteleAuthors(Long id) {
        String sql = """
                DELETE FROM books_authors
                WHERE book_id = ?
           """;
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void insertAuthors(Long id, List<Author> authors) {
        String sql = """
                INSERT INTO bookd_authors(book_id, author_id)
                VALUES (?, ?)
                """;
        authors.forEach(a -> jdbcTemplate.update(sql, id, a.getId()));
    }

    @Override
    public void deleteGenres(Long id) {
        String sql = """
                DELETE FROM books_genres
                WHERE book_id = ?
           """;
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void insertGenres(Long id, List<Genre> genres) {
        String sql = """
                    INSERT INTO books_genres(book_id, genre_id)
                    VALUES(?, ?)
                """;
        genres.stream().forEach(g -> jdbcTemplate.update(sql, id, g.getId()));
    }
}

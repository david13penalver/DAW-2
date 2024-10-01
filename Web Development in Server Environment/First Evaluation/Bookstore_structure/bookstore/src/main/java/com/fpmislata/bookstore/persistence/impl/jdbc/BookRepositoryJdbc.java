package com.fpmislata.bookstore.persistence.impl.jdbc;

import com.fpmislata.bookstore.domain.model.Book;
import com.fpmislata.bookstore.domain.model.Category;
import com.fpmislata.bookstore.domain.model.Genre;
import com.fpmislata.bookstore.persistence.BookRepository;
import com.fpmislata.bookstore.persistence.GenreRepository;
import com.fpmislata.bookstore.persistence.PublisherRepository;
import com.fpmislata.bookstore.persistence.impl.jdbc.mapper.BookRowMapper;
import com.fpmislata.bookstore.persistence.impl.jdbc.mapper.CategoryRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BookRepositoryJdbc implements BookRepository {

    private final JdbcTemplate jdbcTemplate;
    private final AuthorRepositoryJdbc authorRepository;
    private final GenreRepository genreRepository;
    private final PublisherRepository publisherRepository;

    @Override
    public List<Book> getAll() {
        String sql = """
                SELECT * FROM books
                LEFT JOIN categories ON books.category_id = categories.id
                LEFT JOIN publishers ON books.publisher_id = publishers.id
                """;
//        String sql = """
//                SELECT books.title_es FROM books;
//                """;
        return jdbcTemplate.query(sql, new BookRowMapper());
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        String sql = """
                SELECT * FROM books
                LEFT JOIN categories ON books.category_id = categories.id
                WHERE isbn = ?
                """;
        try {
            Book book = jdbcTemplate.queryForObject(sql, new BookRowMapper(), isbn);
            book.setAuthors(authorRepository.getByIsbnBook(isbn));
            book.setGenres(genreRepository.getByIsbnBook(isbn));
            book.setPublisher(publisherRepository.getByIsbnBook(isbn));
            return Optional.of(book);
        }
        catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Book> getBooksByAuthor(int id) {
        String sql = """
                SELECT * FROM books  
                JOIN books_authors ON books.id = books_authors.book_id
                JOIN authors ON books_authors.author_id = authors.id
                WHERE authors.id = ?
                """;
        return jdbcTemplate.query(sql, new BookRowMapper(), id);
    }

    @Override
    public List<Book> getBooksByGenre(int id) {
        String sql = """
                SELECT * FROM books
                JOIN books_genres ON books.id = books_genres.book_id
                JOIN genres ON books_genres.genre_id = genres.id
                WHERE genres.id = ?
                """;    
        return jdbcTemplate.query(sql, new BookRowMapper(), id);
    }
}

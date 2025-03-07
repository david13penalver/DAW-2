package com.fpmislata.bookstore.persistence.dao.db;

import com.fpmislata.bookstore.domain.model.Author;
import com.fpmislata.bookstore.domain.model.Book;
import com.fpmislata.bookstore.domain.model.Genre;

import java.util.List;
import java.util.Optional;

public interface BookDaoDb extends GenericDaoDb<Book>{

    Optional<Book> findByIsbn(String isbn);
    void deteleAuthors(Long id);
    void insertAuthors(Long id, List<Author> authors);
    void deleteGenres(Long id);
    void insertGenres(Long id, List<Genre> genres);
}

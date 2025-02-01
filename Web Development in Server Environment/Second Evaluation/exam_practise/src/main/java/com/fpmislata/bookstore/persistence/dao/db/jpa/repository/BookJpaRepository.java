package com.fpmislata.bookstore.persistence.dao.db.jpa.repository;

import com.fpmislata.bookstore.domain.model.Book;
import com.fpmislata.bookstore.domain.model.ListWithCount;
import com.fpmislata.bookstore.persistence.dao.db.jpa.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface BookJpaRepository extends JpaRepository<BookEntity, Long> {
    BookEntity findByIsbn(String isbn);

    @Query(value = "SELECT b from books b " +
    "JOIN books_authors ba ON b.id = ba.book_id " +
    "JOIN authors a ON ba.author_id = a.id " +
    "WHERE a.id = :id"
    , nativeQuery = true)
    ListWithCount<Book> getAllBooksByAuthor(Long id, int page, int pageSize);
}

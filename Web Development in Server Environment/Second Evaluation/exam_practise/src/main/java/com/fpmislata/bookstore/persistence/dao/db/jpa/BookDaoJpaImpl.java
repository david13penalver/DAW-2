package com.fpmislata.bookstore.persistence.dao.db.jpa;

import com.fpmislata.bookstore.domain.model.Book;
import com.fpmislata.bookstore.domain.model.ListWithCount;
import com.fpmislata.bookstore.persistence.dao.db.BookDaoJpa;
import com.fpmislata.bookstore.persistence.dao.db.jpa.entity.BookEntity;
import com.fpmislata.bookstore.persistence.dao.db.jpa.mapper.BookJpaMappper;
import com.fpmislata.bookstore.persistence.dao.db.jpa.repository.BookJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BookDaoJpaImpl implements BookDaoJpa {

    private final BookJpaRepository bookJpaRepository;

    @Override
    public List<Book> getAll() {
        return List.of();
    }

    @Override
    public ListWithCount<Book> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<BookEntity> bookPage = bookJpaRepository.findAll(pageable);
        return new ListWithCount<Book>(
                bookPage
                        .stream()
                        .map(BookEntity -> BookJpaMappper.INSTANCE.toBook(BookEntity))
                        .toList(),
                bookPage.getTotalElements()
        );
    }

    @Override
    public Optional<Book> findById(long id) {
        return bookJpaRepository.findById(id)
                .map(BookJpaMappper.INSTANCE::toBook);
    }

    @Override
    public long insert(Book book) {
        return 0;
    }

    @Override
    public void update(Book book) {

    }

    @Override
    public void delete(long id) {
        bookJpaRepository.deleteById(id);
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public Book save(Book book) {
        BookEntity bookEntity = BookJpaMappper.INSTANCE.toBookEntity(book);
        return BookJpaMappper.INSTANCE.toBook(bookJpaRepository.save(bookEntity));
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        return Optional.ofNullable(
                bookJpaRepository.findByIsbn(isbn)).map(BookJpaMappper.INSTANCE::toBook);
    }

    @Override
    public ListWithCount<Book> getAllBooksByAuthor(Long id, int page, int pageSize) {
        return bookJpaRepository.getAllBooksByAuthor(id, page, pageSize);
    }
}

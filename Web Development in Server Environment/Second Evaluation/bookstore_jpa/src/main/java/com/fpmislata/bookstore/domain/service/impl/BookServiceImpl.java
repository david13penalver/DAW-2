package com.fpmislata.bookstore.domain.service.impl;

import com.fpmislata.bookstore.common.annotation.DomainService;
import com.fpmislata.bookstore.common.exception.ResourceAlreadyExistsException;
import com.fpmislata.bookstore.domain.model.Author;
import com.fpmislata.bookstore.domain.model.Book;
import com.fpmislata.bookstore.domain.model.Genre;
import com.fpmislata.bookstore.domain.model.ListWithCount;
import com.fpmislata.bookstore.domain.repository.BookRepository;
import com.fpmislata.bookstore.domain.service.BookService;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DomainService
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public List<Book> getAll() {
        return bookRepository.getAll();
    }

    @Override
    public ListWithCount<Book> getAll(int page, int size) {
        return bookRepository.getAll(page, size);
    }

    @Override
    public long count() {
        return bookRepository.count();
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        Book book= bookRepository.findByIsbn(isbn).orElse(null);
        return Optional.ofNullable(book);
    }

    @Override
    public Optional<Book> findById(long id) {
        Book book= bookRepository.findById(id).orElse(null);
        return Optional.ofNullable(book);
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void addAuthor(Book book, Author author) {
        if (book.getAuthors() == null) {
            book.setAuthors(new ArrayList<>());
        }
        if (book.getAuthors().contains(author)) {
            throw new ResourceAlreadyExistsException("Author " + author.getName() + "already exists");
        }
        book.addAuthor(author);
    }

    @Override
    public void addGenre(Book book, Genre genre) {
        if (book.getGenres() == null) {
            book.setGenres(new ArrayList<>());
        }
        if (book.getGenres().contains(genre)) {
            throw new ResourceAlreadyExistsException("Genre " + genre.getId() + "already exists");
        }
        book.addGenre(genre);
    }

    @Override
    public void delete(long id) {
        bookRepository.delete(id);
    }

}

package com.fpmislata.bookstore.domain.user.service.impl;

import com.fpmislata.bookstore.domain.user.model.Author;
import com.fpmislata.bookstore.domain.user.model.Book;
import com.fpmislata.bookstore.domain.user.service.AuthorService;
import com.fpmislata.bookstore.persistence.user.AuthorRepository;
import com.fpmislata.bookstore.persistence.user.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @Override
    public List<Author> getAll() {
        return authorRepository.getAll();
    }

    @Override
    public Optional<Author> findById(int id) {
        return authorRepository.findById(id);
    }

    @Override
    public List<Book> getBooksByAuthor(int id) {
        return bookRepository.getBooksByAuthor(id);
    }
}

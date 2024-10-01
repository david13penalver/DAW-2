package com.fpmislata.bookstore.domain.service.impl;

import com.fpmislata.bookstore.domain.model.Book;
import com.fpmislata.bookstore.domain.model.Genre;
import com.fpmislata.bookstore.domain.service.GenreService;
import com.fpmislata.bookstore.persistence.BookRepository;
import com.fpmislata.bookstore.persistence.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;
    private final BookRepository bookRepository;

    @Override
    public List<Genre> getAll() {
        return genreRepository.getAll();
    }

    @Override
    public List<Book> getBooksByGenre(int id) {
        return bookRepository.getBooksByGenre(id);
    }
}

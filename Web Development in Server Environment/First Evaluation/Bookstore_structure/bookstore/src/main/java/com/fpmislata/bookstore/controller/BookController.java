package com.fpmislata.bookstore.controller;

import com.fpmislata.bookstore.domain.model.Book;
import com.fpmislata.bookstore.domain.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    @Autowired
    private final BookService bookService;

    @GetMapping
    public List<Book> getAll() {
        return bookService.getAll();
    }

    @GetMapping("{isbn}")
    public Optional<Book> findByIsbn(@PathVariable String isbn) {
        return bookService.findByIsbn(isbn);
    }
}

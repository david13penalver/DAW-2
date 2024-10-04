package com.fpmislata.bookstore.controller;

import com.fpmislata.bookstore.controller.webMapper.BookMapper;
import com.fpmislata.bookstore.controller.webModel.BookCollection;
import com.fpmislata.bookstore.controller.webModel.BookDetail;
import com.fpmislata.bookstore.domain.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(BookController.URL)
@RequiredArgsConstructor
public class BookController {

    public static final String URL = "/api/books";

    private final BookService bookService;
    private final BookMapper bookMapper;

    @GetMapping
    public ResponseEntity<List<BookCollection>> getAll() {
        List<BookCollection> bookCollections = bookService.getAll()
                .stream()
                .map(bookMapper::toBookCollection)
                .toList();
        return new ResponseEntity<>(bookCollections, HttpStatus.OK);
    }

    @GetMapping("{isbn}")
    public ResponseEntity<BookDetail> findByIsbn(@PathVariable String isbn) {
        BookDetail bookDetail = bookMapper.toBookDetail(bookService.findByIsbn(isbn));
        return new ResponseEntity<>(bookDetail, HttpStatus.OK);
    }
}

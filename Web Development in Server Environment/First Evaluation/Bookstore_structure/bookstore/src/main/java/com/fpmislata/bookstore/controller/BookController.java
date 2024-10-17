package com.fpmislata.bookstore.controller;

import com.fpmislata.bookstore.controller.common.PaginatedResponse;
import com.fpmislata.bookstore.controller.webMapper.BookMapper;
import com.fpmislata.bookstore.controller.webModel.BookCollection;
import com.fpmislata.bookstore.controller.webModel.BookDetail;
import com.fpmislata.bookstore.domain.service.BookService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(BookController.URL)
@RequiredArgsConstructor
public class BookController {

    public static final String URL = "/api/books";

    private final BookService bookService;

    @GetMapping
    public ResponseEntity<PaginatedResponse<BookCollection>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            HttpServletRequest request) {
        List<BookCollection> bookCollections = bookService
                .getAll(page -1, size)
                .stream()
                .map(BookMapper.INSTANCE::toBookCollection)
                .toList();
        int total = bookService.count();

        String baseUrl = request.getRequestURL().toString();

        PaginatedResponse<BookCollection> response = new PaginatedResponse<>(bookCollections, total, page, size, baseUrl);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("{isbn}")
    public ResponseEntity<BookDetail> findByIsbn(@PathVariable String isbn) {
        BookDetail bookDetail = BookMapper.INSTANCE.toBookDetail(bookService.findByIsbn(isbn));
        return new ResponseEntity<>(bookDetail, HttpStatus.OK);
    }
}

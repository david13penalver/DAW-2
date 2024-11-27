package com.fpmislata.bookstore.controller.user;

import com.fpmislata.bookstore.controller.common.PaginatedResponse;
import com.fpmislata.bookstore.controller.user.webmodel.book.BookCollection;
import com.fpmislata.bookstore.controller.user.webmodel.book.BookDetail;
import com.fpmislata.bookstore.controller.user.webmodel.book.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(BookUserController.URL)
public class BookUserController {

    public static final String URL = "/api/books";

    @Value("${app.base.url}")
    private String baseUrl;

    @Value("${app.pageSize.default}")
    private String defaultPageSize;

    private final BookGetAllUseCase bookGetAllUseCase;
    private final BookCountUseCase bookCountUseCase;
    private final BookFindByIsbnUseCase bookFindByIsbnUseCase;

    @GetMapping
    public ResponseEntity<PaginatedResponse<BookCollection>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(required = false) int size) {

        List<BookCollection> bookCollections = bookGetAllUseCase
                .execute(page -1, pageSize)
                .stream()
                .map(BookMapper.INSTANCE::toBookCollection)
                .toList();

        int total = bookCountUseCase.execute();

        PaginatedResponse<BookCollection> response = new PaginatedResponse<>(bookCollections, total, page, pageSize, baseUrl + URL);
        return ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<BookDetail> findByIsbn(@PathVariable String isbn) {
        BookDetail bookDetail = BookMapper.INSTANCE.toBookDetail(bookFindByIsbnUseCase.execute(isbn));
        return ResponseEntity<>(bookDetail, HttpStatus.OK);
    }
}

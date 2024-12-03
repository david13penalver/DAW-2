package com.fpmislata.bookstore.controller.admin;

import com.fpmislata.bookstore.controller.admin.webmodel.BookCollection;
import com.fpmislata.bookstore.controller.admin.webmodel.BookMapper;
import com.fpmislata.bookstore.controller.common.PaginatedResponse;
import com.fpmislata.bookstore.domain.model.Book;
import com.fpmislata.bookstore.domain.usecase.admin.BookInsertUseCase;
import com.fpmislata.bookstore.domain.usecase.common.BookCountUseCase;
import com.fpmislata.bookstore.domain.usecase.common.BookFindByIsbnUseCase;
import com.fpmislata.bookstore.domain.usecase.common.BookGetAllUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(BookAdminController.URL)
public class BookAdminController {

    public static final String URL = "/api/admin/books";

    @Value("${app.base.url}")
    private String baseUrl;

    @Value("${app.pageSize.default}")
    private String defaultPageSize;

    private final BookGetAllUseCase bookGetAllUseCase;
    private final BookCountUseCase bookCountUseCase;
    private final BookFindByIsbnUseCase bookFindByIsbnUseCase;
    private final BookInsertUseCase bookInsertUseCase;

    // GetAll
    @GetMapping
    public ResponseEntity<PaginatedResponse<BookCollection>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(required = false) Integer size) {
        int pageSize = (size != null) ? size : Integer.parseInt(defaultPageSize);
        List<BookCollection> books = bookGetAllUseCase
                .execute(page - 1, pageSize)
                .stream()
                .map(BookMapper.INSTANCE::toBookCollection)
                .toList();

        int total = bookCountUseCase.execute();

        PaginatedResponse<BookCollection> response = new PaginatedResponse<>(books, total, page, pageSize, baseUrl + URL);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // FindByIdentificador
    @GetMapping("/{isbn}")
    public ResponseEntity<Book> findByIsbn(@PathVariable String isbn) {
        Book book = bookFindByIsbnUseCase.execute(isbn);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    // Insertar
    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Book book) {
        bookInsertUseCase.execute(book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
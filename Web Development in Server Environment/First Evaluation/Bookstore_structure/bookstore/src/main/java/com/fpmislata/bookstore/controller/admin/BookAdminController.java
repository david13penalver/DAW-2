package com.fpmislata.bookstore.controller.admin;

import com.fpmislata.bookstore.controller.admin.webModel.book.BookCollection;
import com.fpmislata.bookstore.controller.admin.webModel.book.BookMapper;
import com.fpmislata.bookstore.controller.common.PaginatedResponse;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(BookAdminController.ADMIN_URL)
public class BookAdminController {

    public static final String ADMIN_URL = "/api/admin/book";

    @Value("${app.base.url}")
    private String baseUrl;

    private final BookAdminService bookAdminService;

    @GetMapping
    public ResponseEntity<PaginatedResponse<BookCollection>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(required = false) Integer size
    ) {
        int pageSize = (size != null) ? size : Integer.parseInt(defaultPageSize);
        List<BookCollection> bookCollections = bookAdminService
                .getAll(page -1, size)
                .stream()
                .map(BookMapper.INSTANCE::toBookCollection)
                .toList();

        int total = bookAdminService.count();

        PaginatedResponse<BookCollection> response = new PaginatedResponse<>(bookCollections, total, page, pageSize, baseUrl + ADMIN_URL);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}

package com.fpmislata.bookstore.controller.admin;

import com.fpmislata.bookstore.controller.common.PaginatedResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(BookAdminController.URL)
public class BookAdminController {

    public static final String URL = "/api/admin/x";

    @Value("${app.base.url}")
    private String baseUrl;

    @Value("${app.pageSize.default}")
    private String defaultPageSize;

    private final UseCase useCase;

    // GetAll
    @GetMapping
    public ResponseEntity<PaginatedResponse<ModelController>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(required = false) Integer size) {
        int pageSize = (size != null) ? size : Integer.parseInt(defaultPageSize);
        List<ModelController> books = useCase
                .execute(page - 1, pageSize)
                .stream()
                .map(MapperController.INSTANCE::toBookCollection)
                .toList();

        int total = useCase.execute();

        PaginatedResponse<ModelController> response = new PaginatedResponse<>(books, total, page, pageSize, baseUrl + URL);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // FindByIdentificador
    @GetMapping("/{identificador}")
    public ResponseEntity<Modelo> findByIsbn(@PathVariable String identificador) {
        Modelo modelo = useCase.execute(identificador);
        return new ResponseEntity<>(modelo, HttpStatus.OK);
    }

    // Insertar
    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Modelo modelo) {
        useCase.execute(modelo);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
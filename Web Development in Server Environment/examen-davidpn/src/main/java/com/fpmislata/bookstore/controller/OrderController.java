package com.fpmislata.bookstore.controller;

import com.fpmislata.bookstore.controller.common.PaginatedResponse;
import com.fpmislata.bookstore.controller.webmodel.OrderCollection;
import com.fpmislata.bookstore.controller.webmodel.OrderMapper;
import com.fpmislata.bookstore.domain.model.Order;
import com.fpmislata.bookstore.domain.model.OrderDetail;
import com.fpmislata.bookstore.domain.usecase.common.GetAllUseCase;
import com.fpmislata.bookstore.domain.usecase.common.InsertBookInOrderUseCase;
import com.fpmislata.bookstore.domain.usecase.common.OrderCountUseCase;
import com.fpmislata.bookstore.domain.usecase.common.OrderFindByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(OrderController.URL)
public class OrderController {

    public static final String URL = "/api/orders";

    @Value("${app.base.url}")
    private String baseUrl;

    @Value("${app.pageSize.default}")
    private String defaultPageSize;

    private final GetAllUseCase getAllUseCase;
    private final OrderCountUseCase orderCountUseCase;
    private final OrderFindByIdUseCase orderFindByIdUseCase;
    private final InsertBookInOrderUseCase insertBookInOrderUseCase;

    @GetMapping()
    public ResponseEntity<PaginatedResponse<OrderCollection>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(required = false) Integer size) {
        int pageSize = (size != null) ? size : Integer.parseInt(defaultPageSize);
        List<OrderCollection> orderCollections = getAllUseCase
                .execute(page - 1, pageSize)
                .stream()
                .map(OrderMapper.INSTANCE::toOrderCollection)
                .toList();

        int total = orderCountUseCase.execute();

        PaginatedResponse<OrderCollection> response = new PaginatedResponse<>(orderCollections, total, page, pageSize, baseUrl + URL);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id) {
        Order order = orderFindByIdUseCase.execute(id);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

//    @PostMapping("/{idOrder}/books/{idBook}")
//    public ResponseEntity<Order> insertBookInOrder(@PathVariable Long idOrder, @PathVariable Long idBook) {
//        Order book = insertBookInOrderUseCase.execute(id, order_id, idBook, quantity, price);
//        return new ResponseEntity<>(book, HttpStatus.OK);
//    }
}

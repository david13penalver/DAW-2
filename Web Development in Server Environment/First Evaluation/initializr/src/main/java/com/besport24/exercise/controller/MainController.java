package com.besport24.exercise.controller;

import com.besport24.exercise.domain.BookService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.awt.print.Book;

@Controller
// Los dos de abajo son con Lombok de cómo vamos a terminan con la inyección de dependencias        
@Data
@RequiredArgsConstructor
// Los dos de arriba son con Lombok de cómo vamos a terminan con la inyección de dependencias
public class MainController {

    private final BookService bookService;

//    @Autowired
//    // @Qualifier("bookServiceImpl") SOLO CUANDO HAYA DOS IMPLEMENTACIONES, PARA SABER CUÁL
//    public MainController(BookService bookService) {
//        this.bookService = bookService;
//    }
    // Por ahora se supone que haremos así la inyección de dependencias

    @GetMapping
    public  void index() {
        System.out.println("Index option");
    }

    @GetMapping("/books")
    public void books() {
        System.out.println("Books option");
    }

    @GetMapping("/books/{id}")
    public void book(@PathVariable int id) {
        System.out.println("Book option " + id);
    }
}

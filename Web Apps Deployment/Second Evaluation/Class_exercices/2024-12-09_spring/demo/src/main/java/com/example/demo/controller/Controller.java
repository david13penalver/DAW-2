package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {
    @GetMapping
    public String hello() {
        return "index.html";
    }
}

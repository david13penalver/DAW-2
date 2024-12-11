package com.fpmislata.bookstore.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.swing.*;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Director {
    private Integer id;
    private String name;
    private Integer birthYear;
    private Integer deathYear;
}

package com.fpmislata.bookstore.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rider {

    private Long id;
    private String name;
    private Long age;
    private String nationality;
    private Team team;
}

package com.fpmislata.bookstore.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CharacterComic {

    private Integer id;
    private String name;
    private String realName;
    private char type;
}

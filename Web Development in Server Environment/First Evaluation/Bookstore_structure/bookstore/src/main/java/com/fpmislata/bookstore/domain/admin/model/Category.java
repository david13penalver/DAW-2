package com.fpmislata.bookstore.domain.admin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    private long id;
    private String nameEs;
    private String nameEn;
    private String slug;
}

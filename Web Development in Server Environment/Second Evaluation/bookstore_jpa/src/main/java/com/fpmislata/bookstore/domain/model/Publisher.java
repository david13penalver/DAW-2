package com.fpmislata.bookstore.domain.model;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Publisher {

    private Long id;
    private String name;
    @Nullable
    private String slug;
}

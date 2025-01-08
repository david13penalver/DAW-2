package com.fpmislata.bookstore.persistence.dao.db.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name_es")
    private String nameEs;
    @Column(name = "name_en")
    private String nameEn;
    private String slug;
}

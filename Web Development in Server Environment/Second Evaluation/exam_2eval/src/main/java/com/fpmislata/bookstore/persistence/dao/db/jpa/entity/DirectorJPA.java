package com.fpmislata.bookstore.persistence.dao.db.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "directors")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DirectorJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String biography;
}

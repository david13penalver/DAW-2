package com.fpmislata.bookstore.persistence.dao.db.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "equipos")
@Data
@NoArgsConstructor
public class TeamJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_equipo")
    private Long id;
    @Column(name = "nombre")
    private String name;
    @Column(name = "pais")
    private String country;
}

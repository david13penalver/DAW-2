package com.fpmislata.bookstore.persistence.dao.db.jpa.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "equipos")
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

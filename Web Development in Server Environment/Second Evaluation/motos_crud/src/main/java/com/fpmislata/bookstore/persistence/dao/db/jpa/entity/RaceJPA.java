package com.fpmislata.bookstore.persistence.dao.db.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "carreras")
@Entity
@Data
@NoArgsConstructor
public class RaceJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carrera")
    private Long id;
    @Column(name = "nombre")
    private String name;
    @Column(name = "fecha")
    private String date;
    @Column(name = "ubicacion")
    private String location;
}

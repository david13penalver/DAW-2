package com.fpmislata.bookstore.persistence.dao.db.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pilotos")
@Data
@NoArgsConstructor
public class RiderJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_piloto")
    private Long id;
    @Column(name = "nombre")
    private String name;
    @Column(name = "edad")
    private Long age;
    @Column(name = "nacionalidad")
    private String nationality;
    @ManyToOne(fetch = FetchType.LAZY)
    private TeamJPA teamJPA;
}

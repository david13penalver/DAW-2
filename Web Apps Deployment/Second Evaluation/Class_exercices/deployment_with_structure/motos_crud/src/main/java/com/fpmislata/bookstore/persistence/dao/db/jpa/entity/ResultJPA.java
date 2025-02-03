package com.fpmislata.bookstore.persistence.dao.db.jpa.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "carrera_piloto")
public class ResultJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carrera_piloto")
    private Long id;
    @Column(name = "posicion")
    private Long position;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_carrera")
    private RaceJPA raceJPA;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_piloto")
    private RiderJPA rider;
}

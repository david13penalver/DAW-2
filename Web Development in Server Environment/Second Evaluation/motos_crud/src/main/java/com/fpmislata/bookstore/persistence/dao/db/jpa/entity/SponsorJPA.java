package com.fpmislata.bookstore.persistence.dao.db.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "patrocinadores")
@Data
@NoArgsConstructor
public class SponsorJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_patrocinador")
    private Long id;
    @Column(name = "nombre")
    private String name;
    private String sector;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_equipo")
    private TeamJPA teamJPA;
}

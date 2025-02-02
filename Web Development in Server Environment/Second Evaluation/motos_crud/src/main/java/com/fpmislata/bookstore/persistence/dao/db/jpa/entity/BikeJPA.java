package com.fpmislata.bookstore.persistence.dao.db.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "motos")
public class BikeJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_moto")
    private Long id;
    @Column(name = "modelo")
    private String model;
    @Column(name = "marca")
    private String brand;
    @Column(name = "cilindrada")
    private Long cylinder_capacity;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_piloto")
    private RiderJPA rider;
}
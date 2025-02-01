package com.fpmislata.bookstore.persistence.dao.db.jpa.entity;

import com.fpmislata.bookstore.domain.model.Rider;
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
    @JoinColumn(name = "modelo")
    private String model;
    @JoinColumn(name = "marca")
    private String brand;
    @JoinColumn(name = "cilindrada")
    private Long cylinder_capacity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_piloto")
    private RiderJPA riderJPA;
}

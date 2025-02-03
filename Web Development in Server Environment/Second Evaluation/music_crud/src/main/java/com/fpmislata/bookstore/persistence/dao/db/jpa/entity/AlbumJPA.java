package com.fpmislata.bookstore.persistence.dao.db.jpa.entity;

import com.fpmislata.bookstore.domain.model.Artist;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Album")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlbumJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "titulo")
    private String title;
    @Column(name = "anio")
    private String year;
    @ManyToOne
    @JoinColumn(name = "artista_id")
    private ArtistJPA artist;
    @ManyToMany
    @JoinTable(name = "Artista_Cancion",
            joinColumns = @JoinColumn(name = "artista_id"),
            inverseJoinColumns = @JoinColumn(name = "cancion_id"))
    private List<SongJPA> songs;
}

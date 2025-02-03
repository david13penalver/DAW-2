package com.fpmislata.bookstore.persistence.dao.db.jpa.entity;

import com.fpmislata.bookstore.domain.model.Album;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Cancion")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SongJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "titulo")
    private String title;
    @Column(name = "duracion")
    private String duration;
    @ManyToOne
    @JoinColumn(name = "album_id")
    private AlbumJPA album;
}

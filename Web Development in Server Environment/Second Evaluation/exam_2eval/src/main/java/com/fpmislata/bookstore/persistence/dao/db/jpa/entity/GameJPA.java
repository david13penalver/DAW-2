package com.fpmislata.bookstore.persistence.dao.db.jpa.entity;

import com.fpmislata.bookstore.domain.model.Director;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "games")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "game_code")
    private String gameCode;
    private String title;
    @Column(name = "release_year")
    private Long releaseYear;
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "director_id")
    private DirectorJPA director;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "games_characters",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "character_id")
    )
    private List<FigureJPA> figures;
}

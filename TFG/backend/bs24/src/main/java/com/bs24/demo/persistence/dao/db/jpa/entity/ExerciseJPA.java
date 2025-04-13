package com.bs24.demo.persistence.dao.db.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "exercises")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exercise_id")
    private int exerciseId;
    private String name;
    private String description;
    @Column(name = "image_url")
    private String imageURL;
    @Column(name = "video_url")
    private String videoURL;
    @Column(name = "is_global")
    private Boolean isGlobal;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id")
    private ExerciseTypeJPA exerciseType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subtype_id")
    private ExerciseSubtypeJPA exerciseSubtype;
}

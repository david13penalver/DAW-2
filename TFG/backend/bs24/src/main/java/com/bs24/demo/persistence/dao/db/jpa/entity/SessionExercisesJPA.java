package com.bs24.demo.persistence.dao.db.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "sessions_exercises")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessionExercisesJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "session_exercises_id")
    private int sessionExercisesId;
    @Column(name = "num_sets")
    private int numSets;
    @Column(name = "num_reps")
    private int numReps;
    @Column(name = "rest_seconds")
    private int restSeconds;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "session_id")
    private List<SessionJPA> session;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "exercise_id")
    private List<ExerciseJPA> exercises;
}

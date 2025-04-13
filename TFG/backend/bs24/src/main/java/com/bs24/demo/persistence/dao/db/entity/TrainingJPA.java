package com.bs24.demo.persistence.dao.db.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "trainings")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainingJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "training_id")
    private int trainingId;
    private String name;
    @Column(name = "training_duration_seconds")
    private int trainingDurationSeconds;
    @Column(name = "date_creation")
    private String dateCreation;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserJPA user;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "session_id")
    private List<SessionJPA> session;
}

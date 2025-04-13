package com.bs24.demo.persistence.dao.db.jpa.repository;

import com.bs24.demo.persistence.dao.db.jpa.entity.TrainingJPA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingJPARepository extends JpaRepository<TrainingJPA, Long> {
}

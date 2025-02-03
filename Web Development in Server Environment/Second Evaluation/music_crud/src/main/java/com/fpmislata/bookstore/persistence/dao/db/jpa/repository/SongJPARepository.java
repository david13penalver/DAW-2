package com.fpmislata.bookstore.persistence.dao.db.jpa.repository;

import com.fpmislata.bookstore.persistence.dao.db.jpa.entity.SongJPA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongJPARepository extends JpaRepository<SongJPA, Long> {
}

package com.fpmislata.bookstore.persistence.dao.db.jpa.repository;

import com.fpmislata.bookstore.persistence.dao.db.jpa.entity.AlbumJPA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumJPARepository extends JpaRepository<AlbumJPA, Long> {
}

package com.fpmislata.bookstore.persistence.dao.db.jpa.repository;

import com.fpmislata.bookstore.persistence.dao.db.jpa.entity.ArtistJPA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistJPARepository extends JpaRepository<ArtistJPA, Long> {
}

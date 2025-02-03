package com.fpmislata.bookstore.persistence.dao.db.jpa.repository;

import com.fpmislata.bookstore.persistence.dao.db.jpa.entity.BikeJPA;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BikeJPARepository extends JpaRepository<BikeJPA, Long> {
}

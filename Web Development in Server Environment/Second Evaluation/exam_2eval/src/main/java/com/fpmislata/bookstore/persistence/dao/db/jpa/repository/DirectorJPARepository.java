package com.fpmislata.bookstore.persistence.dao.db.jpa.repository;

import com.fpmislata.bookstore.persistence.dao.db.jpa.entity.DirectorJPA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorJPARepository extends JpaRepository<DirectorJPA, Long> {
}

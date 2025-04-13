package com.bs24.demo.persistence.dao.db.jpa.repository;

import com.bs24.demo.persistence.dao.db.jpa.entity.UserJPA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJPARepository extends JpaRepository<UserJPA, Long> {
}

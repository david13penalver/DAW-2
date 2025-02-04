package com.fpmislata.bookstore.persistence.dao.db.jpa.repository;

import com.fpmislata.bookstore.persistence.dao.db.jpa.entity.GameJPA;
import org.springframework.data.jpa.repository.JpaRepository;

import java.nio.channels.FileChannel;

public interface GameJPARepository extends JpaRepository<GameJPA, Long> {

    GameJPA findByGameCode(String gameCode);
}

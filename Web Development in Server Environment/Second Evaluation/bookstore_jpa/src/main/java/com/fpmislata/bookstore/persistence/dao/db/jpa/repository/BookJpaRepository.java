package com.fpmislata.bookstore.persistence.dao.db.jpa.repository;

import com.fpmislata.bookstore.persistence.dao.db.jpa.entity.BookEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookJpaRepository extends JpaRepository<BookEntity, Long> {
    @EntityGraph(attributePaths = {"publisher", "category"})
    BookEntity findByIsbn(String isbn);

    @Override
    @EntityGraph(attributePaths = {"publisher", "category"})
    Optional<BookEntity> findById(Long id);
}

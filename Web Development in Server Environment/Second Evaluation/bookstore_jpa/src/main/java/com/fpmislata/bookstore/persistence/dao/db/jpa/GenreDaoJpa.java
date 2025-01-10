package com.fpmislata.bookstore.persistence.dao.db.jpa;

import com.fpmislata.bookstore.domain.model.Genre;
import com.fpmislata.bookstore.domain.model.ListWithCount;
import com.fpmislata.bookstore.persistence.dao.db.GenericDaoDb;
import com.fpmislata.bookstore.persistence.dao.db.jpa.entity.CategoryEntity;
import com.fpmislata.bookstore.persistence.dao.db.jpa.entity.GenreEntity;
import com.fpmislata.bookstore.persistence.dao.db.jpa.mapper.GenreJpaMapper;
import com.fpmislata.bookstore.persistence.dao.db.jpa.repository.GenreJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Primary
@Repository
@AllArgsConstructor
public class GenreDaoJpa implements GenericDaoDb<Genre> {

    private final GenreJpaRepository genreJpaRepository;
    private final GenreJpaMapper genreJpaMapper;

    @Override
    public List<Genre> getAll() {
        return genreJpaRepository.findAll()
                .stream()
                .map(GenreJpaMapper.INSTANCE::toGenre)
                .toList();
    }

    @Override
    public ListWithCount<Genre> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<GenreEntity> genreEntityPage = genreJpaRepository.findAll(pageable);
        return new ListWithCount<Genre>(
                genreJpaRepository.findAll()
                        .stream()
                        .map(GenreJpaMapper.INSTANCE::toGenre)
                        .toList(),
                genreEntityPage.getTotalElements()
        );
    }

    @Override
    public Optional<Genre> findById(long id) {
        return genreJpaRepository.findById(id)
                .map(GenreJpaMapper.INSTANCE::toGenre);
    }

    @Override
    public long insert(Genre genre) {
        return genreJpaRepository.save(GenreJpaMapper.INSTANCE.toGenreEntity(genre)).getId();
    }

    @Override
    public void update(Genre genre) {
        genreJpaRepository.save(GenreJpaMapper.INSTANCE.toGenreEntity(genre)).getId();
    }

    @Override
    public void delete(long id) {
        genreJpaRepository.deleteById(id);
    }

    @Override
    public long count() {
        return genreJpaRepository.count();
    }

    @Override
    public Genre save(Genre genre) {
        return GenreJpaMapper.INSTANCE.toGenre(
                genreJpaRepository.save(GenreJpaMapper.INSTANCE.toGenreEntity(genre))
        );
    }
}

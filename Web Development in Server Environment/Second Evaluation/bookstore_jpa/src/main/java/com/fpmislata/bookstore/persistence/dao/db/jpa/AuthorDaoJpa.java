package com.fpmislata.bookstore.persistence.dao.db.jpa;

import com.fpmislata.bookstore.persistence.dao.db.jpa.entity.AuthorEntity;
import com.fpmislata.bookstore.persistence.dao.db.jpa.repository.AuthorJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
@RequiredArgsConstructor
@Primary
public class AuthorDaoJpa implements AuthorJpaRepository {

    private final AuthorJpaRepository authorJpaRepository;

    @Override
    public List<AuthorEntity> findByBooksIsbn(String isbn) {
        return List.of();
    }

    @Override
    public List<AuthorEntity> findByBooksId(Long id) {
        return List.of();
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends AuthorEntity> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends AuthorEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<AuthorEntity> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public AuthorEntity getOne(Long aLong) {
        return null;
    }

    @Override
    public AuthorEntity getById(Long aLong) {
        return null;
    }

    @Override
    public AuthorEntity getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends AuthorEntity> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends AuthorEntity> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends AuthorEntity> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends AuthorEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends AuthorEntity> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends AuthorEntity> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends AuthorEntity, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends AuthorEntity> S save(S entity) {
        return null;
    }

    @Override
    public <S extends AuthorEntity> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<AuthorEntity> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<AuthorEntity> findAll() {
        return List.of();
    }

    @Override
    public List<AuthorEntity> findAllById(Iterable<Long> longs) {
        return List.of();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(AuthorEntity entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends AuthorEntity> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<AuthorEntity> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<AuthorEntity> findAll(Pageable pageable) {
        return null;
    }
}

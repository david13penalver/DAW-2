package com.fpmislata.bookstore.persistence.dao.db;

import com.fpmislata.bookstore.domain.model.ListWithCount;

import java.util.List;
import java.util.Optional;

public interface GenericDaoDb<T> {

    List<T> getAll();
    ListWithCount<T> getAll(int page, int size);
    Optional<T> findById(long id);
    long insert(T t);
    void update(T t);
    void delete(long id);
    long count();
    T save(T t);

}

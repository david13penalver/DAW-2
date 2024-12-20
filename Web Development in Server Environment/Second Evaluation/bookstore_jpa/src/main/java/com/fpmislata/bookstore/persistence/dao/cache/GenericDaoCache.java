package com.fpmislata.bookstore.persistence.dao.cache;

public interface GenericDaoCache<T> {
    void save(T t);
    void clearCache();
}

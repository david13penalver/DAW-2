package com.fpmislata.bookstore.persistence.dao.db;

import com.fpmislata.bookstore.domain.model.User;

import java.util.List;

public interface UserDaoDb {
    User getByIdBook(Long id);
}

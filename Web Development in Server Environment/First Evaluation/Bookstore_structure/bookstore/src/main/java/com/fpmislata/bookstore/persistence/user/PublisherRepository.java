package com.fpmislata.bookstore.persistence.user;

import com.fpmislata.bookstore.domain.user.model.Publisher;

public interface PublisherRepository {
    Publisher getByIsbnBook(String isbn);
}

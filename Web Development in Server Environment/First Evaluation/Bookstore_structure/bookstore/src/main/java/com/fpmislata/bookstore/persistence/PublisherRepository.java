package com.fpmislata.bookstore.persistence;

import com.fpmislata.bookstore.domain.model.Publisher;

public interface PublisherRepository {
    Publisher getByIsbnBook(String isbn);
}

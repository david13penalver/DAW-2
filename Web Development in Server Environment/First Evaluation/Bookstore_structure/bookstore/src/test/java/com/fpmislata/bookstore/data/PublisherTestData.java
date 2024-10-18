package com.fpmislata.bookstore.data;

import com.fpmislata.bookstore.domain.user.model.Publisher;

import java.util.List;

public class PublisherTestData {
    public static List<Publisher> getPublishers() {
        return List.of(
                new Publisher(1, "Publisher 1", "publisher-1"),
                new Publisher(2, "Publisher 2", "publisher-2")
        );
    }
}

package com.fpmislata.bookstore.controller.user.webmodel.publisher;

import com.fpmislata.bookstore.domain.model.Publisher;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PublisherMapper {

    PublisherMapper INSTANCE = Mappers.getMapper(PublisherMapper.class);

    PublisherDetail toPublisherCollection(Publisher publisher);

    Publisher toPublisher(PublisherDetail publisherCollection);
}

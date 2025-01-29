package com.fpmislata.bookstore.persistence.dao.db.jpa.mapper;

import com.fpmislata.bookstore.domain.model.Publisher;
import com.fpmislata.bookstore.persistence.dao.db.jpa.entity.PublisherEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PublisherJpaMapper {

    PublisherJpaMapper INSTANCE = Mappers.getMapper(PublisherJpaMapper.class);

    PublisherEntity toPublisherEntity(Publisher publisher);

    Publisher toPublisher(PublisherEntity publisherEntity);
}

package com.fpmislata.bookstore.controller.webMapper;

import com.fpmislata.bookstore.controller.webModel.PublisherCollection;
import com.fpmislata.bookstore.domain.model.Publisher;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PublihserMapper {

    PublihserMapper INSTANCE = Mappers.getMapper(PublihserMapper.class);

    PublisherCollection toPublisherCollection(Publisher publisher);
}

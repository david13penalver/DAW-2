package com.fpmislata.bookstore.controller.user.webMapper;

import com.fpmislata.bookstore.controller.user.webModel.PublisherCollection;
import com.fpmislata.bookstore.domain.user.model.Publisher;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PublihserMapper {

    PublihserMapper INSTANCE = Mappers.getMapper(PublihserMapper.class);

    PublisherCollection toPublisherCollection(Publisher publisher);
}

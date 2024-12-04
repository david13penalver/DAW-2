package com.fpmislata.bookstore.controller.webmodel;

import com.fpmislata.bookstore.domain.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderCollection toOrderCollection(Order order);
}

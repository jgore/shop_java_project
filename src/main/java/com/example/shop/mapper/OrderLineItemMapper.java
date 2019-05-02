package com.example.shop.mapper;

import com.example.shop.controller.dto.OrderLineItemDto;
import com.example.shop.entity.OrderLineItem;
import org.springframework.stereotype.Component;

@Component
public class OrderLineItemMapper implements Mapper<OrderLineItem, OrderLineItemDto> {

    @Override
    public OrderLineItem map(OrderLineItemDto dto) {
        OrderLineItem orderLineItem = new OrderLineItem();
        orderLineItem.setId( dto.getId());
        orderLineItem.setAmount(dto.getAmount());
        orderLineItem.setProduct(dto.getProduct());

        return orderLineItem;
    }

    @Override
    public OrderLineItemDto map(OrderLineItem orderLineItem) {

        OrderLineItemDto dto = new OrderLineItemDto();
        dto.setId( orderLineItem.getId() );
        dto.setAmount( orderLineItem.getAmount());
        dto.setProduct( orderLineItem.getProduct());

        return dto;
    }
}

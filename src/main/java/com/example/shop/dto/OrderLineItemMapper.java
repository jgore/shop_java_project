package com.example.shop.dto;

import com.example.shop.entity.OrderLineItem;
import org.springframework.stereotype.Component;

@Component
public class OrderLineItemMapper implements AbstractMapper<OrderLineItem, OrderLineItemDto> {


    @Override
    public OrderLineItem dtoToEntity(OrderLineItemDto orderLineItemDto) {
        if (orderLineItemDto == null) {
            return  null;
        }
        OrderLineItem orderLineItem = new OrderLineItem();
        orderLineItem.setId(orderLineItemDto.getId());
        return orderLineItem;
    }

    @Override
    public OrderLineItemDto entityToDto(OrderLineItem orderLineItem) {
        if (orderLineItem == null){
            return null;
        }
        OrderLineItemDto orderLineItemDto = new OrderLineItemDto();
        orderLineItemDto.setId(orderLineItem.getId());
        return orderLineItemDto;
    }
}

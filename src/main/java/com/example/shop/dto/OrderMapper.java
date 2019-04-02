package com.example.shop.dto;

import com.example.shop.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class OrderMapper implements AbstractMapper<Order, OrderDto> {

    @Autowired
    OrderLineItemMapper orderLineItemMapper;


    @Override
    public Order dtoToEntity(OrderDto orderDto) {
        if (orderDto == null) {
            return null;
        }
        Order order = new Order();
        order.setId(orderDto.getId());
        order.setOrderLineItemList(orderDto.getOrderLineItemDtos().stream()
                .map(e -> orderLineItemMapper.dtoToEntity(e))
                .collect(Collectors.toList()));
        return order;
    }

    @Override
    public OrderDto entityToDto(Order order) {
        return null;
    }
}

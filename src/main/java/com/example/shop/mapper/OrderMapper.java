package com.example.shop.mapper;

import com.example.shop.controller.dto.OrderDto;
import com.example.shop.entity.Order;
import com.example.shop.entity.OrderLineItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collector;
import java.util.stream.Collectors;

@Component
public class OrderMapper implements Mapper<Order, OrderDto> {

    private OrderLineItemMapper orderLineItemMapper;

    @Autowired
    public OrderMapper(OrderLineItemMapper orderLineItemMapper) {
        this.orderLineItemMapper = orderLineItemMapper;
    }

    @Override
    public Order map(OrderDto orderDto) {
        Order order = new Order();
        order.setId( orderDto.getId());
        order.setOrderLineItems( orderDto.getOrderLineItems().stream()
                .map( orderLineItem -> orderLineItemMapper.map(orderLineItem))
                .collect(Collectors.toList()));
        return order;
    }

    @Override
    public OrderDto map(Order order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId( order.getId());
        orderDto.setOrderLineItems( order.getOrderLineItems().stream()
                .map( orderLineItemDto -> orderLineItemMapper.map( orderLineItemDto) )
                .collect(Collectors.toList()));
        return orderDto;
    }
}

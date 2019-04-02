package com.example.shop.dto;

import java.util.List;
import java.util.Objects;

public class OrderDto {

    private Long id;
    private List<OrderLineItemDto> orderLineItemDtos;


    public OrderDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<OrderLineItemDto> getOrderLineItemDtos() {
        return orderLineItemDtos;
    }

    public void setOrderLineItemDtos(List<OrderLineItemDto> orderLineItemDtos) {
        this.orderLineItemDtos = orderLineItemDtos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDto orderDto = (OrderDto) o;
        return Objects.equals(id, orderDto.id) &&
                Objects.equals(orderLineItemDtos, orderDto.orderLineItemDtos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderLineItemDtos);
    }
}

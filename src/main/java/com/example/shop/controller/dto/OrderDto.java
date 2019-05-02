package com.example.shop.controller.dto;

import java.util.List;

public class OrderDto {

    private Long id;

    private List<OrderLineItemDto> orderLineItemsDtos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<OrderLineItemDto> getOrderLineItems() {
        return orderLineItemsDtos;
    }

    public void setOrderLineItems(List<OrderLineItemDto> orderLineItemsDtos) {
        this.orderLineItemsDtos = orderLineItemsDtos;
    }
}
